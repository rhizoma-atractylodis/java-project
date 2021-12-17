package springcloud.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;
}
