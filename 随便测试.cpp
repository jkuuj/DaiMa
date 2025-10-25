//#include <iostream>
//using namespace std;
//int main()
//{
//    int a,b;
//    cin>>a>>b;//a ���ָ���  B�߷�����
//    int B[a][a];
//    for(int p=1;p<=b;p++)
//    {
//        int c,d,e;//c��� d�յ� e����
//        cin>>c>>d>>e;
//        B[c-1][d-1]=e;
//    }
//    int j[a];
//    j[0]=0;
//    int x,y,z;
//    for(x=1;x<=a;x++)
//    {
//        for(y=1;y<=b;y++)
//        {
//            if(x=1)
//            {
//                j[y-1]=B[0][y-1];
//            }
//            if(j[y-1]>=j[x-1]+B[x-1][y-1])
//            {
//                j[y-1]=j[x-1]+B[x-1][y-1];
//            }
//
//        }
//    }
//
//    for(int q=0;q<=a;q++)
//    {
//        cout<<j[q];
//    }
//    return 0;
//}
//
//
//
#include <iostream>
using namespace std;

const int INF = 1000000; // ����һ���㹻�������ʾ�����

int main() {
    int a, b;
    cin >> a >> b; // a ���ָ��� B�߷�����
    int B[a][a];
    
    // ��ʼ��B����Ϊ�����
    for (int i = 0; i < a; ++i) {
        for (int j = 0; j < a; ++j) {
            B[i][j] = INF;
        }
    }
    
    // ��ȡ�ߵ���Ϣ
    for (int p = 0; p < b; ++p) {
        int c, d, e; // c��� d�յ� e����
        cin >> c >> d >> e;
        B[c - 1][d - 1] = e; // ȷ��������ȷ
    }
    
    int j[a];
    j[0] = 0; // ��ʼ�����Ϊ0
    for (int i = 1; i < a; ++i) {
        j[i] = B[0][i]; // ��ʼ����һ�е����·��
    }
    
    // ��̬�滮�������·��
    for (int i = 1; i < a; ++i) {
        for (int k = 0; k < a; ++k) {
            for (int m = 0; m < a; ++m) {
                if (j[k] + B[k][m] < j[m]) {
                    j[m] = j[k] + B[k][m]; // �������·��
                }
            }
        }
    }
    
    // ������·��
    for (int q = 0; q < a; ++q) {
        cout << j[q] << (q < a - 1 ? " " : "\n");
    }
    
    return 0;
}

