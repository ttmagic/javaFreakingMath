package freakingmath;

import java.util.Random;

public class PhepTinh {
    public static final int CONG =1;
    public static final int TRU =2;
    public static final int NHAN =3;
     
    private int a;
    private int b;
    private int kq;
    private int kqFake1;
    private int kqFake2;
    private int doKho;
    private int phepTinh;
    private int hienThi;

    PhepTinh() {
        a = 0;
        b = 0;
        kq = kqFake1 = kqFake2 = 0;
        doKho = 0;
        phepTinh = 1;
        hienThi = 1;
    }

    void taoPhepTinh(int phep, int dokho) //pheptinh =1 = cong;2 = tru ; 3 = nhan;
    {
        phepTinh = phep;
        Random rand = new Random();
        a = (rand.nextInt(dokho) + 1);
        b = (rand.nextInt(dokho) + 1);
        hienThi = (rand.nextInt(4) + 1);
        if (phepTinh == CONG) // 1- phep cong
        {
            kq = (a + b);
            kqFake1 = (kq - (rand.nextInt(5) + 1));
            kqFake2 = (kq + rand.nextInt(5) + 1);
        } else if (phepTinh == TRU) // 2- phep tru
        {
            kq = (a - b);
            kqFake1 = (kq - (rand.nextInt(5) + 1));
            kqFake2 = (kq + rand.nextInt(5) + 1);
        } else if (phepTinh == NHAN) //3- phep nhan
        {
            kq = (a * b);
            kqFake1 = (kq - (rand.nextInt(10) + 1));
            kqFake2 = (kq + rand.nextInt(10) + 1);
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getKq() {
        return kq;
    }

    public int getKqFake1() {
        return kqFake1;
    }

    public int getKqFake2() {
        return kqFake2;
    }

    public int getPhepTinh() {
        return phepTinh;
    }

    public int getHienThi() {
        return hienThi;
    }
}
