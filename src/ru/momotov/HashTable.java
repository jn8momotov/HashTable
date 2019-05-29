package ru.momotov;

// Вариант 1
// Хеш-таблица с разрешением коллизий методом цепочек. Хранение
// нескольких пар ключ/значение в одной ячейке хеш-таблицы
// осуществляется с помощью списка на основе массива (реализация
// должна быть своя, не использовать библиотечные классы).

public class HashTable {

    private ArrayList[] array;

    HashTable(int size) {
        array = new ArrayList[size];
    }

    // Метод добавления значения.
    // Если значение с таким ключом уже есть в хеш-таблице, это значение
    // заменяется на новое.
    public void put(String key, String value) {
        int index = hashFunction(key);
        if (array[index] == null) {
            array[index] = new ArrayList(key, value);
            return;
        }
        array[index].addPair(key, value);
    }

    // Метод поиска значения по ключу
    public String get(String key) {
        int index = hashFunction(key);
        return array[index].getSearhedValue(key);
    }

    // Метод удаления по ключу
    public void remove(String key) {
        int index = hashFunction(key);
        array[index].removePair(key);
    }

    // Метод печати всех пар ключ/значение в таблице
    public void print() {
        for (int index = 0; index < array.length; index++) {
            if (array[index] != null) {
                array[index].printArrayList();
            }
        }
    }

    // Хэш-функция
    private int hashFunction(String key) {
        return Math.abs(key.hashCode()) % array.length;
    }

}
