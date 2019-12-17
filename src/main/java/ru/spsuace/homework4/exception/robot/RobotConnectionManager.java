package ru.spsuace.homework4.exception.robot;

/**
 * Класс отвечает за установку соединения с роботом.
 * <p>
 * Задание: нужно создать исключение (1 балл) и реализовать метод moveRobot (2 балла)
 * Дополнительное задание: Сделать простую реализациюю RobotConnectionManager(1 балл) и RobotConnection (1 балл)
 * и класс Robot (2 балла максимум)
 */
public interface RobotConnectionManager {
    /**
     * Делает попытку соединиться с роботом, и если получилось, возвращает это соединение.
     * Если соединение не установилось - то метод кидает непроверяемое исключение
     */
    RobotConnection getConnection() throws RobotException;

    static final int EXCEPTION_LIMIT = 2;

    /**
     * Метод должен открыть соединение и отправить робота в указанную точку. При неудаче, повторить попытку еще 2 раза,
     * Если так же произошла неудача, то прокинуть эту ошибку на уровень выше.
     * Попытка считается успешной, если соединение открылось и вызвался метод moveRobotTo без исключений.
     */
    static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int exceptionLimit = EXCEPTION_LIMIT;
        RobotConnection robotConnection = null;
        do {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
            } catch (RobotException e) {
                if (exceptionLimit > 1) {
                    exceptionLimit--;
                } else {
                    throw e;
                }
            }
        } while (exceptionLimit > 0 && robotConnection == null);
    }
}
