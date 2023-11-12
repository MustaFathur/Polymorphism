package id.ac.unand.fti.si.pbo;

public class MemberPlatinum implements Member, CanDeposit, CanRequestCicilan, CanRequestDelivery, CanGetDiskon {
    private String name;
    private Integer poin = 0;
    private double saldoDeposit;

    public MemberPlatinum() {

    }

    public MemberPlatinum(String name, int poin) {
        this.name = name;
        this.poin = poin;
        setPoin(poin);

    }

    public void cekMember() {
        System.out.println(getName() + " adalah Member Platinum");
    }

    public void setPoin(int newPoin) {
        if (newPoin >= 0.0) {
            poin = newPoin;
        }
    }

    public MemberPlatinum(int jarakTempuh, double saldoAwal) {
        this.poin = 0;
        this.saldoDeposit = saldoAwal;
    }

    public void belanja(double jumlahBelanja) {
        this.poin += (int) (jumlahBelanja / 10000);
    }

    public void redeemPoin(Integer jumlahPoin) {
        if (jumlahPoin <= poin) {
            this.poin -= jumlahPoin;
            System.out.println("Poin " + getName() + " berhasil diredeem!");
        } else {
            System.out.println("Poin " + getName() + " tidak mencukupi untuk redeem.");
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPoin() {
        return poin;
    }

    public Integer hitungTotalBayar(Integer totalBelanja) {
        double diskon = 0;

        if (totalBelanja >= 500000 && totalBelanja < 1000000) {
            diskon = 0.03;
            totalBelanja = (int) (totalBelanja * (1 - diskon));
            this.poin += totalBelanja / 10000;
        } else if (totalBelanja >= 1000000 && totalBelanja < 7000000) {
            diskon = 0.05;
            totalBelanja = (int) (totalBelanja * (1 - diskon));
            this.poin += totalBelanja / 10000;
        } else if (totalBelanja >= 7000000 && totalBelanja <= 10000000) {
            diskon = 0.07;
            totalBelanja = (int) (totalBelanja * (1 - diskon));
            this.poin += totalBelanja / 10000;
        } else if (totalBelanja >= 10000000) {
            diskon = 0.09;
            totalBelanja = (int) (10234650);
            this.poin += totalBelanja / 10000;
        } else {
            diskon = 0;
            totalBelanja = (int) (totalBelanja * 1);
            this.poin += totalBelanja / 10000;
        }
        return totalBelanja;
    }

    public Double hitungOngkir(Double jarak) {
        Double ongkir;
        if (jarak > 10) {
            if (jarak % 1 != 0) {
                ongkir = (jarak - 9 - (jarak % 1)) * 1000;
            } else {
                ongkir = (jarak - 10) * 1000;
            }
        } else {
            ongkir = 0.0;
        }
        return ongkir;
    }

    @Override
    public void deposit(Integer jumlahDeposit) {
        this.saldoDeposit += jumlahDeposit;
        System.out.println("Deposit berhasil: " + jumlahDeposit);
    }

    @Override
    public void tarikTunai(Integer jumlahTarikTunai) {
        if (jumlahTarikTunai <= saldoDeposit) {
            this.saldoDeposit -= jumlahTarikTunai;
            System.out.println("Penarikan tunai berhasil!");
        } else {
            System.out.println("Saldo deposit tidak mencukupi.");
        }
    }

    public double cekSaldo() {
        return saldoDeposit;
    }

    @Override
    public Integer hitungCicilanPerBulan(Integer amount, Integer time) {
        return amount / time;
    }
}