package mobileProgramming.hmhBackend.todolist.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class TodoListKey implements Serializable {

    private Long id;
    private Long member;
}
