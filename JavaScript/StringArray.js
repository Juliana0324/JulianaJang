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


//접근하려는 위치에 반환할 글자가 없는 경우 대괄호는 undefined를, charAt은 빈 문자열을 반환합니다.

let str = `Hello`;

console.log( str[9] ); // undefined
console.log( str.charAt(9) ); // '' (빈 문자열)


let myString = 'Codeit';

for (let str of myString) {
  console.log(str);
}


/*
가장 중요한 차이는 배열은 'mutable(바뀔 수 있는)' 자료형인 반면 문자열은 'immutable(바뀔 수 없는)' 자료형이라는 것입니다.

배열은 요소에 접근해서 할당연산자를 통해 요소를 수정할 수 있었죠?

문자열은 한 번 할당된 값을 수정할 수 없습니다. 다르게 표현해서, 변수에 할당된 문자열을 바꾸고 싶다면, 일부를 바꾸는 게 아니라 새로운 문자열을 지정해주어야 한다는 것이죠.
*/
// 배열은 mutable
let myArray = ['C', 'o', 'd', 'e', 'i', 't'];
myArray[0] = 'B';
console.log(myArray);

// 문자열은 immutable
let myString = 'Codeit';
myString[0] = 'B';
console.log(myString);
(6) ["B", "o", "d", "e", "i", "t"]
Codeit
