//배열의 메소드(Array's Method)
let members= ['쿤갈레', 'Zerrard66', '우리생각해써','흙토끼','End Miracle'];

console.log(members);

//배열의 첫요소를 삭제
//members.splice(0,1);
//shift 사용하기
members.shift();
console.log(members);

//배열의 마지막요소를 삭제
//members.splice(members.length-1, 1);
//pop메소드 
members.pop();
console.log(members);


//배열의 첫요소로 값 추가
//members.splice(0,0, 'NiceCodeit');
//unshift(value);
members.unshift('NiceCodeit');


//배열의 마지막 요소로 값 추가
//members.splice(members.length, 0, 'HiCodeit');
//push(value);

members.push('HiCodeit');
console.log(members);

//출력결과
//[ 'NiceCodeit', 'Zerrard66', '우리생각해써', '흙토끼', 'HiCodeit' ]



//indexOf 
let brands = ['Google', 'Kakao', 'Naver', 'Kakao'];
console.log(brands.indexOf('Kakao'));   //1: 여러번 포함되어 있으면 처음 발견된 인덱스 리턴
console.log(brands.indexOf('Daum'));    //-1: 포함이 안되어 있으면 -1 

//lastIndexOf
console.log(brands.lastIndexOf('Kakao'));
console.log(brands.lastIndexOf('Daum'));


//reverse
let brands = ['Google', 'Kakao', 'Naver', 'Kakao'];
console.log(brands);
brands.reverse();
console.log(brands);
