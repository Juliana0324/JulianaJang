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

    
    //���� ����(�̸�, ��, ��, ���� �¼� ��)�� �Ķ���ͷ� �޾� �����ϴ� �޼ҵ��Դϴ�.
    //�Է¹��� rowChar�� �迭�� index�� ����ϱ� ����  getRowIndex �޼ҵ带 �̿��ϼ���!
    public boolean reserve(String name, char rowChar, int col, int numSeat) {
    	//D7�� 4�ڸ� �����ϱ�
    	//row = 3+1;�� ����� A���� D���� 4��� ���� ���� �� �ֽ��ϴ�.
    	int row = getRowIndex(rowChar)+1;
    	
    	// ������ ���� ���ĺ� ������ ũ�ų�
    	// ������ ���� ���� ������ ũ�ų�
    	// ������ ���� ���� ������ �ڸ��� ���� �������� (ex. D7-4���ڸ� == 7+4 �ε� 7���� �����ϴϱ� 10���� �����⋚���� �ϳ�����)
    	// ����Ұ�
    	if(getRowIndex(rowChar)>=26|| col>colCount || col+numSeat-1>colCount) return false;
    	else {
    		for(int i=0; i<numSeat; i++) {
    			//A�� 0�̱⶧���� �ϳ��� ���ֱ�!
    			//������ �¼���ŭ �������ִ� �޼ҵ� ����(�ݺ���)
    			Seat reservation = seats[row-1][col-1+i];
    			
    			if(reservation.isOccupied()) {
    				//���� ������ ���ִٸ� 
    				//������ �ڸ���ŭ �� cancel
    				//ex> col:7�̶��	(d7��)
    				// i=2�϶� seats[]
    				for(int j=0;j<i;j++) {
    					seats[row-1][col-1+j].cancel();    			    					
    				}
    				return false;
    			}
    			//�����̵ȴٸ� ������ �̸��� �޾ƿðԿ�.
    			reservation.reserve(name);
    		}
    		//������ �Ϸ�ƴٸ�  true�� 
    		return true;
    	}

    }

    // -'A'�� ���ִ� ������ ASCII�ڵ�� ������ �ִµ�
    // ���� D���� �����ϰڴ�, �ϸ�  D=68, A=65 �̱⋚����
    // RowIndex�� ���� 3�� ������ ��
    private int getRowIndex(char uppercaseChar) {
    	return uppercaseChar - 'A';
    }


    //�̸� name���� ����� �ڸ��� ����ϰ�, ��ҵ� �¼��� ���� �����մϴ�.
    //����� �ڸ��� ���ٸ� 0�� �����ϰ���?
    public int cancel(String name) {
    	int cnt = 0;
    	
    	for(int i=0;i<rowCount;i++) {
    		for(int j=0;j<colCount;j++) {
    			Seat seat = seats[i][j];
    			//Seat class�� �ִ� �̸��� �����ϴٸ� �������!
    			if(seat.isOccupied() && seat.match(name)) {
    				seat.cancel();
    				cnt++;
    			}
    		}
    	}
    	return cnt;
        // ���⿡ �ڵ带 �ۼ��ϼ���
    }

    //�Ķ���ͷ� �޴� '��', '��', '�¼� ��'�� �ش�Ǵ� ��� �¼��� ������ ����մϴ�.
    //A6�� �¼����� 3�� ���
    public int cancel(char rowChar, int col, int numSeat) {
    	//row = 0+1;
    	int row = getRowIndex(rowChar)+1;
    	//����� �¼��� �� 
    	int cnt=0;
    	
    	//���� �ۼ��� ���� ����� ���� ������ ũ�ų�, ���� ���� ����� ���� ������ ũ�� 0�� ����
    	if(row>rowCount || col>colCount) {
    		return 0;
    	}
    	// ���� ����� �¼����� �¼������� ���ٸ�
    	// ��ҵ� ��ŭ�� ������ֱ�
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

    //����� ��� �¼� ���� �����ϴ� �޼ҵ��Դϴ�.
    public int getNumberOfReservedSeat() {
    	int cnt=0;
    	//���� ���� ��� �ݺ����� ���� ����� �ڼ��� ���� �ľ��մϴ�
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