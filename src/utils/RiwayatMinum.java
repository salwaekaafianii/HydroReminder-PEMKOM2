package utils;

import java.io.Serializable;

public class RiwayatMinum implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tanggal;
    private int totalDiminum;
    private int target;

    public RiwayatMinum(String tanggal, int totalDiminum, int target) {
        this.tanggal = tanggal;
        this.totalDiminum = totalDiminum;
        this.target = target;
    }

    // Getter dan setter (jika perlu)
    public String getTanggal() {
        return tanggal;
    }

    public int getTotalDiminum() {
        return totalDiminum;
    }

    public int getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return tanggal + " | Total: " + totalDiminum + " ml | Target: " + target + " ml";
    }
}
