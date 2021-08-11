//template String
//꼭 문자열에 `(backtick)을 사용할것
let year = 2018;
let month=3;
let day=11;
console.log('생년월일은 '+year+"년 "+month+"월 "+day+"일 입니다" );
console.log(`생년월일은 ${year}년 ${month}월 ${day}일 입니다`);


let myNumber =3;
function getTwice(x){
  return x*3;
}
console.log(`${myNumber}의 두배는 ${getTwice(myNumber)}입니다`);


//예제
function calcWage(name, time, wage) {
    let total = time * wage;
  
    console.log(`${name}님의 근무시간은 총 ${time}시간이며, 최종급여는 ${total}원 입니다.`); // 코드를 채워 넣으세요.
  }
  
  calcWage('김윤식', 208, 11340);
  calcWage('성규재', 175, 12160);
  calcWage('손태웅', 161, 13070);
  calcWage('허우선', 222, 10980);