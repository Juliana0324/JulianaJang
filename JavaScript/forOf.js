//for..of
let influencer = ['suwonlog', 'small.tiger', 'Minam.ludens', 'cu_convenience24']
for(let i=0;i<influencer.length; i++){
    console.log(influencer[i]);
}

for(let element of influencer){
    console.log(element);
}

//출력결과
// suwonlog
// small.tiger
// Minam.ludens
// cu_convenience24

//for in 문을 사용할 경우, 
//일반적인 객체를 사용하기때문에
//사용 하지않는것을 권장
for(let index in influencer){
    console.log(influencer[index]);
}


//예시
// 투표 결과 리스트
let votes = [
    '이재식', '이재식', '이규하', '이규하', '이규하',
    '이재식', '이재식', '이규하', '이규하', '이재식',
    '이규하', '이규하', '이규하', '이규하', '이재식',
    '이재식', '이규하', '이재식', '이재식', '이재식',
    '이재식', '이재식', '이규하', '이규하', '이규하',
    '이규하', '이규하', '이재식', '이규하', '이규하',
    '이규하', '이규하', '이재식', '이규하', '이규하',
    '이규하', '이재식', '이재식', '이재식', '이규하',
  ];
  
  // 후보별 득표수 객체
  let voteCounter = {};
  
  // votes 배열을 이용해서 voteCounter 객체를 정리하기
  for (let name of votes) {
    // 코드를 작성하세요.
    if(name in voteCounter){
      voteCounter[name] += 1;
    }else{
      voteCounter[name] = 1;
    }
    
    
  }
  
  
  // 후보별 득표수 출력
  console.log(voteCounter);