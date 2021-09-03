package CodeBox;

public class Theater {
    private Seat[][] seats;

    private int rowCount, colCount;

    public Theater(int rowCount, int colCount) {
        if (rowCount > 26) {
            rowCount = 26; // number of alphabets
        }
        seats = new Seat[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                seats[i][j] = new Seat();
            }
        }

        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    
    //예약 정보(이름, 열, 행, 예약 좌석 수)를 파라미터로 받아 예약하는 메소드입니다.
    //입력받은 rowChar를 배열의 index로 사용하기 위해  getRowIndex 메소드를 이용하세요!
    public boolean reserve(String name, char rowChar, int col, int numSeat) {
    	//D7열 4자리 예약하기
    	//row = 3+1;을 해줘야 A부터 D까지 4라는 값이 나올 수 있습니다.
    	int row = getRowIndex(rowChar)+1;
    	
    	// 예약할 열이 알파벳 수보다 크거나
    	// 예약할 행이 행의 수보다 크거나
    	// 예약할 행의 수와 예약할 자리의 수를 더했을때 (ex. D7-4개자리 == 7+4 인데 7부터 시작하니까 10으로 나오기떄문에 하나빼줌)
    	// 예약불가
    	if(getRowIndex(rowChar)>=26|| col>colCount || col+numSeat-1>colCount) return false;
    	else {
    		for(int i=0; i<numSeat; i++) {
    			//A가 0이기때문에 하나씩 뺴주기!
    			//예약한 좌석만큼 예약해주는 메소드 생성(반복문)
    			Seat reservation = seats[row-1][col-1+i];
    			
    			if(reservation.isOccupied()) {
    				//만약 예약이 차있다면 
    				//예약한 자리만큼 다 cancel
    				//ex> col:7이라면	(d7열)
    				// i=2일때 seats[]
    				for(int j=0;j<i;j++) {
    					seats[row-1][col-1+j].cancel();    			    					
    				}
    				return false;
    			}
    			//예약이된다면 예약자 이름을 받아올게요.
    			reservation.reserve(name);
    		}
    		//예약이 완료됐다면  true로 
    		return true;
    	}

    }

    // -'A'를 해주는 이유는 ASCII코드와 관련이 있는데
    // 만약 D열을 예약하겠다, 하면  D=68, A=65 이기떄문에
    // RowIndex의 값은 3이 나오게 됨
    private int getRowIndex(char uppercaseChar) {
    	return uppercaseChar - 'A';
    }


    //이름 name으로 예약된 자리를 취소하고, 취소된 좌석의 수를 리턴합니다.
    //예약된 자리가 없다면 0을 리턴하겠죠?
    public int cancel(String name) {
    	int cnt = 0;
    	
    	for(int i=0;i<rowCount;i++) {
    		for(int j=0;j<colCount;j++) {
    			Seat seat = seats[i][j];
    			//Seat class에 있는 이름과 동일하다면 취소진행!
    			if(seat.isOccupied() && seat.match(name)) {
    				seat.cancel();
    				cnt++;
    			}
    		}
    	}
    	return cnt;
        // 여기에 코드를 작성하세요
    }

    //파라미터로 받는 '열', '행', '좌석 수'에 해당되는 모든 좌석의 예약을 취소합니다.
    //A6번 좌석부터 3개 취소
    public int cancel(char rowChar, int col, int numSeat) {
    	//row = 0+1;
    	int row = getRowIndex(rowChar)+1;
    	//취소할 좌석의 수 
    	int cnt=0;
    	
    	//만약 작성한 열이 취소한 열의 수보다 크거나, 행의 수가 취소한 행의 수보다 크면 0을 리턴
    	if(row>rowCount || col>colCount) {
    		return 0;
    	}
    	// 만약 취소할 좌석수가 좌석수보다 많다면
    	// 취소된 만큼만 출력해주기
    	else if(col+numSeat-1>colCount) {
    		numSeat = col+numSeat-1-colCount;
    	}
    	
    	for(int i=0; i<numSeat;i++) {
    		if(seats[row-1][col-1+i].isOccupied()) {
    			seats[row-1][col-1+i].cancel();
    			cnt++;
    		}
    	}
    	return cnt;
    }

    //예약된 모든 좌석 수를 리턴하는 메소드입니다.
    public int getNumberOfReservedSeat() {
    	int cnt=0;
    	//열과 행을 모두 반복문을 돌려 예약된 자석의 수를 파악합니다
    	for(int i=0; i<rowCount;i++) {
    		for(int j=0; j<colCount;j++) {
    			Seat seat = seats[i][j];
    			if(seat.isOccupied()) {
    				cnt++;
    			}
    		}
    	}
    	return cnt;
    }

    public void printSeatMatrix() {
        System.out.print("  ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i);
        }
        System.out.println();

        for (int i = 0; i < rowCount; i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if (s.isOccupied()) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}