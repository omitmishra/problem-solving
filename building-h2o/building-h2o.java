class H2O {

     private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;

    public H2O() {
        hydrogenSemaphore = new Semaphore(2);
        oxygenSemaphore = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        oxygenSemaphore.acquire();

        try {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        } finally {
            hydrogenSemaphore.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        hydrogenSemaphore.acquire(2);

        try {
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
        } finally {
            oxygenSemaphore.release(2);
        }
    }
}