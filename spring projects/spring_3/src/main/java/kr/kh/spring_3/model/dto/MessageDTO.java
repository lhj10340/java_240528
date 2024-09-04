package kr.kh.spring_3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDTO {
	String url;
	String msg;
}
