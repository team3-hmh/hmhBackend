package mobileProgramming.hmhBackend.todolist.service;

import lombok.RequiredArgsConstructor;
import mobileProgramming.hmhBackend.join.entity.Member;
import mobileProgramming.hmhBackend.join.entity.MemberRepository;
import mobileProgramming.hmhBackend.todolist.domain.TodoList;
import mobileProgramming.hmhBackend.todolist.domain.TodoListRepository;
import mobileProgramming.hmhBackend.todolist.dto.TodoListDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;
    private final MemberRepository memberRepository;

    public List<TodoList> getTodos(Long member) {
        Optional<Member> optionalMember = memberRepository.findById(member);
        if (optionalMember.isPresent()) {
            return optionalMember.get().getTodoLists();
        } else {
            throw new RuntimeException();
        }
    }

    public void saveTodo(TodoListDto todoListDto) {
        Optional<Member> optionalMember = memberRepository.findById(todoListDto.getMember());
        if (optionalMember.isPresent()) {
            TodoList todoList = TodoList.builder()
                    .id(todoListDto.getId())
                    .member(optionalMember.get())
                    .content(todoListDto.getContent())
                    .date(todoListDto.getDate())
                    .build();
            todoListRepository.save(todoList);
            optionalMember.get().addTodoList(todoList);
        } else {
            throw new RuntimeException();
        }
    }

    public void deleteTodo(TodoListDto todoListDto) {
        Optional<TodoList> optionalTodoList = todoListRepository.findById(todoListDto.getId());
        if (optionalTodoList.isPresent()) {
            TodoList todoList = optionalTodoList.get();
            todoList.getMember().delTodoList(todoList);
            todoListRepository.delete(todoList);
        } else {
            throw new RuntimeException();
        }
    }
}
