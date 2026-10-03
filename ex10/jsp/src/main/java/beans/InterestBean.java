package beans;

public class InterestBean {

    private double p;
    private double n;
    private double r;
    private double interest;

    public InterestBean() {
    }

    public void setP(double p) {
        this.p = p;
    }

    public void setN(double n) {
        this.n = n;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getP() {
        return p;
    }

    public double getN() {
        return n;
    }

    public double getR() {
        return r;
    }

    public double getInterest() {
        interest = (p * n * r) / 100;
        return interest;
    }
}

