//String 
let myString = 'Hi Codeit';

//양끝공백제거
console.log(myString.trim());

//문자열의 길이
console.log(myString.length); //9
console.log(myString.charAt(3));
//charAt메소드 #C

//대괄호 표기법
console.log(myString[3]);
//C

//대소문자 변환
console.log(myString.toUpperCase());
console.log(myString.toLowerCase());

//요소탐색
console.log(myString.indexOf('a')); //앞 부터 -1
console.log(myString.lastIndexOf('i')); //7

//부분문자열 출력
console.log(myString.slice(0,2)); //Hi
console.log(myString.slice(3));   //Codeit
console.log(myString.slice());    //Hi Codeit


