//while반복문

let i=30;
while(i%7 !==0 ){
    console.log(`${i} 코드잇 최고!`);
    i++;
}

console.log(i); //35

//예문
// while 반복문을 사용하여 1 이상 100 이하의 홀수를 모두 출력해 보세요.ㄴ

let i=0;
while(i<100){
    i++;
  if(i%2===1){
  console.log(i);
    
}
}


//약수구하기
const N = 180;
// 여기에 코드를 작성해 주세요.
let i=0;
let cnt=0;
while(i<=N){
  i++;
  if(N%i==0){
    cnt+=1;
    console.log(i);
  }

}
console.log(`${N}의 약수는 총 ${cnt}개입니다.`)
