package com.example.SpringData_5DZ.controller;

import com.example.SpringData_5DZ.action.TrackUserAction;
import com.example.SpringData_5DZ.repositories.TaskRepositories;
import com.example.SpringData_5DZ.model.Task;
import com.example.SpringData_5DZ.model.Status;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/alltask")
public class TaskController {
    private final TaskRepositories taskRepositories;

    /**
     * Добавление  задачи
     * @RequestBody позволяет нам получить тело запроса
     */
    @TrackUserAction
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setCreationDate(LocalDateTime.now());
        return taskRepositories.save(task);
    }

    /**
     * Получение всех задач
     * @findAll() метод JpaRepository
     * возвращает все объекты
     */
    @TrackUserAction
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepositories.findAll();
    }

    /**
     * Получение задачи по статусу
     */
    @TrackUserAction
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Status status) {
        return taskRepositories.findByStatus(status);
    }

    /**
     * Обновление статуса задачи по id
     * @save(Task) метод JpaRepository
     * Сохраняет заданную сущность.
     * Используйте возвращенный экземпляр для дальнейших операций, поскольку операция сохранения могла полностью изменить экземпляр сущности.
     * Параметры:
     * entity - не должно быть null.
     * ВОЗВРАТ:
     * сохраненный объект никогда не будет равен null.
     */
    @TrackUserAction
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task Task = taskRepositories.findById(id).orElse(null);
        if (Task != null) {
            Task.setStatus(task.getStatus());
            return taskRepositories.save(Task);
        } else {
            return null;
        }
    }

    /**
     * Удаление задачи по id
     * @deleteById(id) метод JpaRepository
     * Удаляет объекты, идентифицированные по заданным идентификаторам, с помощью одного запроса.
     */
    @TrackUserAction
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepositories.deleteById(id);
    }
}
