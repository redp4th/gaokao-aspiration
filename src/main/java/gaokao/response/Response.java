package gaokao.response;

public class Response {
    private String msg;
    private Object data;
    private int error_code;

    public Response(String msg, Object data, int error_code) {
        this.msg = msg;
        this.data = data;
        this.error_code = error_code;
    }

    public Response() {
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public int getError_code() {
        return error_code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
