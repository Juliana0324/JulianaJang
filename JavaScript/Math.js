//Math 객체

console.log(Math.abs(-10)); //양수 10
console.log(Math.abs(10));  //양수 10

console.log(Math.max(2,-1,4,5,0));
//5

console.log(Math.min(2,-1,4,5,0));
//-1

//거듭제곱
console.log(Math.pow(2,3)); //8
console.log(Math.pow(5,2)); //25

//제곱근 
console.log(Math.sqrt(25)); //5
console.log(Math.sqrt(49)); //7

//반올림
console.log(Math.round(2.3));
console.log(Math.round(2.4));
console.log(Math.round(2.49));
console.log(Math.round(2.5));
console.log(Math.round(2.6));

/*
2
2
2
3
3
*/

//버림 : Foor 
console.log(Math.floor(2.4));
console.log(Math.floor(2.49));
console.log(Math.floor(2.8));
console.log('-');
//올림: ceil
console.log(Math.ceil(2.4));
console.log(Math.ceil(2.49));
console.log(Math.ceil(2.8));

//난수
console.log(Math.random());
console.log(Math.random());
console.log(Math.random());
console.log(Math.random());

//정수를 랜덤값으로 사용방법
Math.floor(Math.random());

console.log(Math.floor(Math.random() * (10-0))+0);

//이자율 계산기
// 여기에 코드를 작성해 주세요.
function interestCalculator(rate,payment,term){
    let interest = payment*term*(term+1)/2*rate/12;
    interest = Math.round(interest);
    console.log(interest);
  }
  
  
  // 이율이 4.3%일 때 매월 80만원씩 24개월 납입할 경우
  interestCalculator(0.043, 800000, 24);
  
  // 이율이 4.3%일 때 매월 60만원씩 24개월 납입할 경우
  interestCalculator(0.043, 600000, 24);