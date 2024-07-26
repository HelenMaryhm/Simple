package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageStructureBean {

    @JsonProperty(value = "folder", required = true)
    private FolderBaseBean folderBean;

    @JsonProperty(value = "message", required = true)
    private MessageBean messageBean;

    @JsonProperty(value = "structure", required = true)
    private MessageStructurePart messageStructurePartBean;

    public MessageStructurePart getMessageStructurePartBean() {
        return messageStructurePartBean;
    }

    public void setMessageStructurePartBean(MessageStructurePart messageStructurePartBean) {
        this.messageStructurePartBean = messageStructurePartBean;
    }

    public FolderBaseBean getFolderBean() {
        return folderBean;
    }

    public void setFolderBean(FolderBaseBean folderBean) {
        this.folderBean = folderBean;
    }

    public MessageBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }
}