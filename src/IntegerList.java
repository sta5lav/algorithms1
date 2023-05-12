public interface IntegerList {

        // Добавление элемента.
        // Вернуть добавленный элемент
        // в качестве результата выполнения.
        int add(int item);

        // Добавление элемента
        // на определенную позицию списка.
        // Если выходит за пределы фактического
        // количества элементов или массива,
        // выбросить исключение.
        // Вернуть добавленный элемент
        // в качестве результата выполнения.
        int add(int index, int item);

        // Установить элемент
        // на определенную позицию,
        // затерев существующий.
        // Выбросить исключение,
        // если индекс больше
        // фактического количества элементов
        // или выходит за пределы массива.
        int set(int index, int item);

        // Удаление элемента.
        // Вернуть удаленный элемент
        // или исключение, если подобный
        // элемент отсутствует в списке.
        int remove(Integer item);

        // Удаление элемента по индексу.
        // Вернуть удаленный элемент
        // или исключение, если подобный
        // элемент отсутствует в списке.
        int remove(int index);

        // Проверка на существование элемента.
        // Вернуть true/false;
        boolean contains(int item);

        // Поиск элемента.
        // Вернуть индекс элемента
        // или -1 в случае отсутствия.
        int indexOf(int item);

        // Поиск элемента с конца.
        // Вернуть индекс элемента
        // или -1 в случае отсутствия.
        int lastIndexOf(int item);

        // Получить элемент по индексу.
        // Вернуть элемент или исключение,
        // если выходит за рамки фактического
        // количества элементов.
        int get(int index);

        // Сравнить текущий список с другим.
        // Вернуть true/false или исключение,
        // если передан null.
        boolean equals(IntegerList otherList);

        // Вернуть фактическое количество элементов.
        int size();

        // Вернуть true,
        // если элементов в списке нет,
        // иначе false.
        boolean isEmpty();

        // Удалить все элементы из списка.
        void clear();

        // Создать новый массив
        // из строк в списке
        // и вернуть его.
        int[] toArray();

        void sort();

}
