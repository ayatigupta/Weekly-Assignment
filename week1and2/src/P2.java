
 class ParkingSystem {

    String[] spots = new String[10];

    private int hash(String plate) {
        return Math.abs(plate.hashCode()) % spots.length;
    }

    public void park(String plate) {

        int idx = hash(plate);

        while (spots[idx] != null) {
            idx = (idx + 1) % spots.length;
        }

        spots[idx] = plate;
        System.out.println("Parked at " + idx);
    }
}