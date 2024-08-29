package kr.kh.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Pagination.PageMaker;
import Pagination.PostCriteria;
import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class PostService {

	@Autowired
	PostDAO postDao;
	@Resource
	String uploadPath;

	public List<CommunityVO> getCommunityList() {
		return postDao.selectCommunityList();
	}

	public List<PostVO> getPostList(PostCriteria cri) {
		if(cri == null) {
			return null;
		}
		return postDao.selectPostList(cri);
	}

	public PageMaker getPageMaker(PostCriteria cri) {
		if(cri == null) {
			return null;
		}
		int totalCount = postDao.selectPostTotalCount(cri);
		return new PageMaker(3, cri, totalCount);
	}

	public boolean insertPost(PostVO post, MemberVO user, MultipartFile[] fileList) {
		
		if(post == null || user == null) {
			return false;
		}
		
		boolean res;
		
		try {
			post.setPo_me_id(user.getMe_id());
			res = postDao.insertPost(post);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		if(!res) {
			return false;
		}
		
		
		if(fileList == null || fileList.length == 0) {
			return true;
		}
		
		// 첨부파일 추가
		
		for(MultipartFile file : fileList) {
			uploadFile(file, post.getPo_num());
		}
		
		return true;
	}

	private void uploadFile(MultipartFile file, int po_num) {
			
		if(file == null || file.getOriginalFilename().length() == 0) {
			return;
		}
		
		try {
			String fi_ori_name = file.getOriginalFilename();
			// 첨부파일을 서버에 업로드 후, 경로가 포홤된 파일명을 가져온다.
			String fi_name =
			UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			// DB에 첨부파일 정보를 추가한다.
			FileVO fileVo = new FileVO(fi_name, fi_ori_name, po_num );
			postDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void updateView(Integer po_num) {
		
		postDao.updateView(po_num);
	}

	public PostVO getPost(Integer po_num) {
		return postDao.selectPost(po_num);
	}

	public List<FileVO> getFileList(Integer po_num) {
		return postDao.selectFileList(po_num);
	}

	
}
