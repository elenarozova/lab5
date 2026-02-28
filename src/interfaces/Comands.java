package interfaces;

import data.LabWork;

/**
 * Базовый интерфейс для всех команд
 * Все конкретные команды должны реализовывать этот интерфейс и определять
 * логику выполнения в методе {@link #implementCommand()}.
 *
 * @author Елена
 */

public interface Comands {
    void implementCommand(String[] args);
}
