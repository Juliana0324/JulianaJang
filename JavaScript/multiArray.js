let twoDimensional = [[1,2], [3,4]];

console.log(twoDimensional[0][1]);
//출력결과 : 2

//예상문제
let groups = [
	['영준', '캡틴'], 
	['태순', '우재'],
	['재훈', '지웅'],
	['윤형', '동욱'],
	['규식', '소원'],
];

let teams = [
	[],
	[],
];

// 여기에 코드를 작성해 주세요.
for(let i=0; i<groups.length; i++){
    for(let j=0;j<groups[i].length;j++){
      teams[j][i]=groups[i][j];
    }
}

// 테스트 코드
console.log(teams[0]);
console.log(teams[1]);