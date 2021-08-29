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




//예제
//형돈이 가사만 출력

let lyrics = "[재석]너에게 나 하고 싶었던 말 고마워 미안해 함께 있어서 할 수 있어서 웃을 수 있어[준하] 정말 고마웠어 내 손을 놓지 않아줘서 힘을 내볼게 함께 있다면 두렵지 않아[홍철] 내가 늘 웃으니까 내가 우습나 봐 하지만 웃을 거야 날 보고 웃는 너 좋아[명수] 자꾸만 도망치고 싶은데 저 화려한 큰 무대 위에 설 수 있을까? 자신 없어..[하하] 지금까지 걸어온 이 길을 의심하지는 마 잘못 든 길이 때론 지도를 만들었잖아[형돈] 혼자 걷는 이 길이 막막하겠지만 느리게 걷는 거야 천천히 도착해도 돼[길] 술 한 잔 하자는 친구의 말도 의미 없는 인사처럼 슬프게 들릴 때 날 찾아와";
let memberName = '형돈';
let memberPart = null;




// 선택한 맴버의 시작파트 인덱스 값.
let startSearch = lyrics.indexOf(`[${memberName}]`);
// 선택한 맴버의 시작파트부터 문자열의 마지막 까지 슬라이스.
memberPart = lyrics.slice(startSearch);
// 잘려진 문자열 중 다음맴버의 시작파트 인덱스 값.
let endSearch = memberPart.indexOf('[', 1);
// endSearch 인덱스 값을 가지고 원하는 부분만 잘라냄.
let test = memberPart.slice(0, endSearch);


console.log(test);
