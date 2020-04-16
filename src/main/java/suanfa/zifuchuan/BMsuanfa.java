package suanfa.zifuchuan;

/**
 * https://mp.weixin.qq.com/s/_3bbFdBcVb-2L4sdtOv3yQ
 * @author sergei
 * @create 2020-04-14
 */
public class BMsuanfa {
    //��ģʽ���У�����index�±�֮ǰ���ַ��Ƿ�ͻ��ַ�ƥ��
    private static int findCharacter(String pattern, char badCharacter, int index) {
        for(int i = index - 1; i >= 0; i--) {
            if(pattern.charAt(i) == badCharacter) {
                return i;
            }
        }
    //ģʽ�������ڸ��ַ�������-1
        return -1 ;
    }

    public static int boyerMoore(String str,String pattern) {
        int strLength = str.length();
        int patternLength = pattern.length();
        //ģʽ������ʼλ��
        int start = 0;
        while(start <= strLength - patternLength) {
            int i;
            //�Ӻ���ǰ������ַ��Ƚ�
            for(i = patternLength - 1; i >= 0 ; i--) {
                if(str.charAt(start + i) != pattern.charAt(i))
                    //���ֻ��ַ��������Ƚϣ�i��¼�˻��ַ���λ��
                    break;
                }
            if(i <0) {
            //ƥ��ɹ������ص�һ��ƥ����±�λ��
                return start;
            }
            //Ѱ�һ��ַ���ģʽ���еĶ�Ӧ
            int charIndex = findCharacter(pattern, str.charAt(start + i), i);
            //���㻵�ַ�������λ��
            int bcOffset = charIndex >= 0? i - charIndex : i +1;
                start += bcOffset;
            }
            return -1;
        }

    public static void main(String[] args) {
        String str ="GTTATAGCTGGTAGCGGCGAA";
        String pattern ="GTAGCGGCG";
        int index = boyerMoore(str, pattern);
        System.out.println("�״γ���λ�ã�"+ index);
    }
}
