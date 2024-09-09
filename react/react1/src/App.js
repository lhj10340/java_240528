import './css/App.css'; // css 폴더에 App.css가 있고, 연결할 때 사용.

import Button from "./Button";

function App() {

  // arr1을 복사해서 arr2를 만들고 싶어서 다음과 같이 했더니, 원하는 결과가 나타나지 않았다.
  // arr1과 arr2가 공유

  var arr1 = [1,2,3];
  console.log(arr1);
  var arr2 = [...arr1];
  console.log(arr2);
  arr2.push(4); // arr2에 4를 추가했더니,
  console.log(arr1); // arr1에 4가 같이 추가 (같이 추가됐다기 보다는 하나를 공유했기 때문에 발생한 결과)
  
  console.log('..........')

  //arr3을 복사해서 arr4를 만들고 싶어서 전개연산자를 사용했더니 원하는 결과가 나왔다.
  var arr3 = [1,2,3];
  console.log(arr3);
  var arr4 = [...arr3]; // 전개연산자 : 배열이나 객체를 복사할 때, 사용한다.
  console.log(arr4);
  arr4.push(4);
  console.log(arr3);
  
  //appleCount라는 변수에 arr5에 있는 1이 저장되고,
  //bananaCount라는 변수에 arr5에 있는 2가 저장되고,
  //orangeConut라는 변수에 arr5에 있는 3이 저장되도록 작성

  // 일단 알고있는 방식으로 작성해볼 것.

 /* var arr5 = [1,2,3];

  var appleCount = arr5[0];
  var bananaCount = arr5[1];
  var orangeCount = arr5[2];
    => 번지를 이용해서 해도 되지만, 변수 선언 시, 
        [] 안에 각 변수명을 써주면 해당 번지에 맞는 값들이 변수에 맵핑이 된다.

  console.log(appleCount);
  console.log(bananaCount);
  console.log(orangeCount); */

  // 강사님이 알려주신 방법

  var arr5 = [1,2,3];
  var [appleCount, bananaCount, orangeCount] = arr5;

  console.log(appleCount);
  console.log(bananaCount);
  console.log(orangeCount);

  var [text1, text2] = ['버튼on', '버튼off'];
  var on = true;

  function btnOnClick(){
    alert('On 버튼 클릭')
  }
  
  function btnOffClick(){
    alert('Off 버튼 클릭')
  }

  return (
    <div>
     { on ? <Button text={text1} type={"button"} className={"btn"} click= {btnOnClick} on={on}/> : ''}
     {!on ? <Button text={text2} type={"submit"} className={"btn"} click= {btnOffClick} on={on}/> : ''}
      {/* <Button type="submit" className={{a:"a"}}/> */}
    </div>
  );
}

export default App;
