let codeit = {
    name: '코드잇',
    'born Year':2017,
    bornYear:2019,
    isVeryNice: true,
    worstCourse:null,
    bestCourse:{
      title: '자바 스크립트 프로그래밍 기초',
      lanuage:'JavaScript'
    }
  };
  
  //점표 표기법
  console.log(codeit.bornYear);
  //2019
  
  //대괄호 표기법[objectName['propertyName']]
  console.log(codeit['born'+' Year']);
  //2017
  
  console.log(codeit.bestCourse.title);
  console.log(codeit.bestCourse['title']);
  
  console.log(codeit.bestCourse['teacher']);
  //undefined

  
//   객체의 프로퍼티 네임의 자료형은 문자열이지만, 반드시 따옴표로 감싸줘야 할 필요는 없습니다. 다만

// 첫번째 글자가 문자, 밑줄, 달러 기호 중 하나로 시작하지 않는 경우
// 띄어쓰기를 해야하거나
// 그리고 하이픈을 써야 하는 경우에는
// 따옴표로 감싸주어야 합니다.

//ex
let myVoca = {
	// 코드를 작성해 주세요.
  'function':"함수",
  variable:"변수",
  constant:"상수",
  local:"지역의" ,
  global:"전반적인"
};

console.log(myVoca);
console.log(myVoca.local);
console.log(myVoca.constant);
console.log(myVoca.function);



//수정하기
console.log(codeit.name);   //코드잇
codeit.name='codeit';       //객체 초기화및 재설정
console.log(codeit.name);   //codeit

//객체 추가하기
console.log(codeit.ceo);   //undefined
codeit.ceo='홍길동';       //객체 초기화및 재설정
console.log(codeit.ceo);   //홍길동으로 추가됩니다.

//삭제하기(delete)
console.log(codeit.worstCourse);  //null
delete codeit.worstCourse;        //삭제
console.log(codeit.worstCourse);  //undefined


//in 연산자
console.log(codeit.name !== undefined); //true
console.log('name' in codeit);    //true


if('name' in codeit){
  console.log(`name 값은 ${codeit.name} 입니다`);
}
else{
  console.log('name 프로퍼티는 존재하지 않습니다.')
}

// name값은 codeit입니다
​

//예제
let myVoca = {
	function: '함수',
	variable: '변수',
	constant: '상수',
	local: '지역의',
	global: '전반적인',
};


/*
시원이는 지난번에 외웠던 영어단어 5가지 중에서 function, constant, local은 이제 확실하게 다 외웠습니다.

오늘 외울 단어는

[extend] = 확장하다
[export] = 내보내다
[import] = 불러오다
[default value] = 기본값

총 4가지입니다.
 */
// 1. 이미 외운 단어 3개를 삭제해 주세요.
// 여기에 코드를 작성해 주세요.

delete myVoca.function;
delete myVoca.constant;
delete myVoca.local;

console.log(myVoca);
console.log(myVoca.constant);


// 2. 오늘 외울 단어 4개를 추가해 주세요.
// 여기에 코드를 작성해 주세요.
myVoca.extend='확장하다';
myVoca.export='내보내다';
myVoca.import = '불러오다';
myVoca['default'+' value'] = '기본값';

console.log(myVoca);
console.log(myVoca.export);


// 3. default value의 뜻을 출력해 주세요.
// 여기에 코드를 작성해 주세요.
console.log(myVoca['default'+' value']);