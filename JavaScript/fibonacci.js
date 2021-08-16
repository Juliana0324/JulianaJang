//내가 쓴 답
let a1 = 1;
let a2 = 1;
let a3;

console.log(a1);
console.log(a2);

for(let i=1; i<=50; i++){
  a3 = a1+a2;
  if(a3>12586269025){
    break;
  }else{
    console.log(a3);
  }
  a1=a2;
  a2=a3;
}


// 다른답
let current = 1;
let previous = 0;

for (let i = 1; i <= 50; i++) {
  console.log(current);
  let temp = previous;  // previous를 임시 보관소 temp에 저장
  previous = current;
  current = current + temp;  // temp에는 기존 previous 값이 저장돼 있음
}

//while문 답
let current = 1;
let previous = 0;
let i = 1;

while (i <= 50) {
  console.log(current);
  let temp = previous;  // previous를 임시 보관소 temp에 저장
  previous = current;
  current = current + temp;  // temp에는 기존 previous 값이 저장돼 있음
  i++;
}