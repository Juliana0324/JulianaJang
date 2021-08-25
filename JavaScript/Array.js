let courseRanking = {
    '1st': '자바 스크립트 프로그래밍 기초',
    '2st': 'Git으로 배우는 버전 관리',
    '3st' : '컴퓨터 개론',
    '4st': '파이썬 프로그래밍 기초'
  };

  //배열로 만들기
  let courseRanking1 = [
    '자바 스크립트 프로그래밍 기초',
    'Git으로 배우는 버전 관리',
    '컴퓨터 개론',
    '파이썬 프로그래밍 기초'
  ];

  //index== Property
  //console.log(배열이름[index]);

  console.log(courseRanking1[0]);


let members= ['쿤갈레', 'Zerrard66', '우리생각해써','흙토끼','End Miracle'];

console.log(typeof members);
//objects
console.log(members.length);
//==> 총갯수

//추가
members[5] = 'NiceCodeit';
console.log(members[5]);

//수정
members[3] = '달토끼';
console.log(members[3]);


//예제
//온도바꾸기
let celsiusTemps = [27, 25, 26, 22, 28, 27, 21];
let fahrenheitTemps = [];

// 여기에 코드를 작성해 주세요.
for(let i=0; i<celsiusTemps.length; i++){
  fahrenheitTemps[i] = (celsiusTemps[i]*9/5)+32;
}

// fahrenheitTemps 테스트
console.log(fahrenheitTemps);




//배열의 메소드
//삭제
delete members[4]; // <empty item>으로 뜬다
console.log(members);


//splice => 완전히 삭제하기
members.splice(4);

//하지만 1번 메소드를 splice해버리면 1번째고 다 삭제
members.splice(1)
//출력결과
//[ '쿤갈레' ]

//splice(startIndex, deleteCount)
//1번인덱스로부터 2개를 삭제
members.splice(1,2);
console.log(members);
//출력결과: [ '쿤갈레', '흙토끼' ]

//splice(startIndex, deleteCount, item)
members.splice(1,1, 'NiceCodeit', 'HiCodeit');
console.log(members);

//출력결과: [ '쿤갈레', 'NiceCodeit', 'HiCodeit', '우리생각해써', '흙토끼' ]






//예상문제
let fruits = ['레몬', '토마토', '딸기', '바나나'];
let ages = [20, 24, 25, 29, 30, 33];
let numbers = [];

// fruits 배열에 '토마토'를 삭제하고 그 자리에 '사과', '청포도' 를 추가해 주세요.
fruits.splice(1,1,'사과','청포도');

// fruits 배열의 첫 번째 요소를 삭제해 주세요.
fruits.splice(0,1);

// ages 배열에 마지막 요소를 삭제해 주세요.
ages.splice(ages.length-1);


// ages 배열의 2번, 3번 인덱스를 26, 28로 변경해 주세요.
ages.splice(2,0,26,28);

// numbers 배열에 1, 2, 3, 5, 8, 9를 순서대로 추가해 주세요.
  numbers.splice(1,6,1,2,3,5,8,9)


// 반복문을 활용해서 numbers 배열의 요소들 중 홀수를 모두 삭제해 주세요.
for(let i=0; i<numbers.length;i++){
  if(numbers[i]%2 == 1){
    numbers.splice(i,1);
    i--;
  }
}


// 테스트 코드
console.log(fruits[1]);
console.log(fruits[0]);
console.log(ages[ages.length - 1]);
console.log(ages[3]);
console.log(numbers[3]);
console.log(numbers);