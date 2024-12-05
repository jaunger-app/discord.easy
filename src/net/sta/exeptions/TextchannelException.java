package net.sta.exeptions;

public class TextchannelException extends Exception {
    public TextchannelException(String message, Throwable cause) {
        throw new NullPointerException("Error! Please Check that you place the permission on the right place!");
    }
}
