package Lab_3.exception;

import Lab_3.Sweeper;

public class SweeperException extends Exception{
    public SweeperException(String message) {
        super(message);
    }

    public SweeperException(String message, Throwable cause) {
        super(message, cause);
    }
    public static void validateData(Sweeper sweeper)
    {
        try {
            if (sweeper.getSweeperAge() < 18 || sweeper.getSweeperAge() > 50) {
                throw new SweeperException("AGE ERROR");
            }
            if (sweeper.getSweeperHeight() < 100 || sweeper.getSweeperHeight() > 200)
            {
                throw new SweeperException("HEIGHT ERROR");
            }
            if (sweeper.getSweeperWeight() < 70 || sweeper.getSweeperWeight() > 150)
            {
                throw new SweeperException("WEIGHT ERROR");
            }
            if (sweeper.getBroomCount() < 0)
            {
                sweeper.setBroomUsing(null);
                throw new SweeperException("BROOM COUNT ERROR");
            }
        } catch (SweeperException e) {
            System.out.println(e.getMessage());
        }
    }
}
