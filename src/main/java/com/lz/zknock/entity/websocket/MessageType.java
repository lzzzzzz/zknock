package com.lz.zknock.entity.websocket;

/**app消息类型代码*/
public class MessageType {

    public static final int MESSAGE_NORMAL=0x01;//普通文字消息

    public static final int MESSAGE_IMAGE=0x02;//图片消息

    public static final int MESSAGE_AUDIO=0x03;//音频消息

    public static final int MESSAGE_MEDIA=0x04;//媒体信息

    public static final int MESSAGE_HTML=0x05;//富文本信息

    public static final int MESSAGE_BRODCAST=0x06;//广播消息
}
