package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;

import javax.annotation.Nullable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolderBaseBean {
    /**
     * The id of the folder represented by this object.
     */
    @Nullable
    private Integer id;

    /**
     * The name of the folder represented by this object.
     */
    @Nullable
    private String name;
    /**
     * Message expiration property of folder. The time in days after which the messages in a folder are cleaned up.
     */
    @Nullable
    private Long messageExpiration;

    /**
     * The id of the account associated with the folder represented by this object.
     */
    @Nullable
    private Integer acctId;

    /**
     * Folder type assocaited with this folder.
     */
    @Nullable
    private List<String> type;

    /**
     * The label type of the folder represented by this object.
     */
    @Nullable
    private String labelType;

    /**
     * Deleted folder counter.
     */
    private Long deletedId;

    /**
     * The uid to be assigned to the next message in the folder of the external account.
     */
    @Nullable
    private Integer extAcctUidNext;

    /**
     * List of external folder ids that were previously assigned to this folder.
     */
    @Nullable
    private List<Integer> extFidList;

    /**
     * The name of this folder in the external account.
     */
    @Nullable
    private String extAcctFolderName;

    /**
     * The sync state on the external server for this folder.
     */
    @Nullable
    private JsonNode extAcctSyncState;

    /**
     * The uid validity of this folder in the external account.
     */
    @Nullable
    private Long extAcctUidValidity;

    /**
     * The ext acct old cycle revision number associated with this folder.
     */
    @Nullable
    private Integer extAccOldCycleRev;

    /**
     * The id of this folder in the external account.
     */
    @Nullable
    private Integer extFolderId;

    /**
     * Folder size.
     */
    private Long size;

    /**
     * Count of messages in the folder.
     */
    private Long count;

    /**
     * Folder unseen count.
     */
    private Long unseen;

    /**
     * Highest Mod seq.
     */
    private Long highestModSeq;

    /**
     * Uid for the next message in the folder.
     */
    private Long uidNext;

    /**
     * Uid validity of the folder.
     */
    private Long uidValidity;

    /**
     * The Folder Status, to keep track of status.
     */
    @Nullable
    private String extAcctRenameStatus;

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public Long getMessageExpiration() {
        return messageExpiration;
    }

    public void setMessageExpiration(@Nullable Long messageExpiration) {
        this.messageExpiration = messageExpiration;
    }

    @Nullable
    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(@Nullable Integer acctId) {
        this.acctId = acctId;
    }

    @Nullable
    public List<String> getType() {
        return type;
    }

    public void setType(@Nullable List<String> type) {
        this.type = type;
    }

    @Nullable
    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(@Nullable String labelType) {
        this.labelType = labelType;
    }

    public Long getDeletedId() {
        return deletedId;
    }

    public void setDeletedId(Long deletedId) {
        this.deletedId = deletedId;
    }

    @Nullable
    public Integer getExtAcctUidNext() {
        return extAcctUidNext;
    }

    public void setExtAcctUidNext(@Nullable Integer extAcctUidNext) {
        this.extAcctUidNext = extAcctUidNext;
    }

    @Nullable
    public List<Integer> getExtFidList() {
        return extFidList;
    }

    public void setExtFidList(@Nullable List<Integer> extFidList) {
        this.extFidList = extFidList;
    }

    @Nullable
    public String getExtAcctFolderName() {
        return extAcctFolderName;
    }

    public void setExtAcctFolderName(@Nullable String extAcctFolderName) {
        this.extAcctFolderName = extAcctFolderName;
    }

    @Nullable
    public JsonNode getExtAcctSyncState() {
        return extAcctSyncState;
    }

    public void setExtAcctSyncState(@Nullable JsonNode extAcctSyncState) {
        this.extAcctSyncState = extAcctSyncState;
    }

    @Nullable
    public Long getExtAcctUidValidity() {
        return extAcctUidValidity;
    }

    public void setExtAcctUidValidity(@Nullable Long extAcctUidValidity) {
        this.extAcctUidValidity = extAcctUidValidity;
    }

    @Nullable
    public Integer getExtAcctOldCycleRev() {
        return extAccOldCycleRev;
    }

    public void setExtAcctOldCycleRev(@Nullable Integer extAccOldCycleRev) {
        this.extAccOldCycleRev = extAccOldCycleRev;
    }

    @Nullable
    public Integer getExtFolderId() {
        return extFolderId;
    }

    public void setExtFolderId(@Nullable Integer extFolderId) {
        this.extFolderId = extFolderId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getUnseen() {
        return unseen;
    }

    public void setUnseen(Long unseen) {
        this.unseen = unseen;
    }

    public Long getHighestModSeq() {
        return highestModSeq;
    }

    public void setHighestModSeq(Long highestModSeq) {
        this.highestModSeq = highestModSeq;
    }

    public Long getUidNext() {
        return uidNext;
    }

    public void setUidNext(Long uidNext) {
        this.uidNext = uidNext;
    }

    public Long getUidValidity() {
        return uidValidity;
    }

    public void setUidValidity(Long uidValidity) {
        this.uidValidity = uidValidity;
    }

    /**
     * @return the extAcctRenameStatus
     */
    @Nullable
    public String getExtAcctRenameStatus() {
        return extAcctRenameStatus;
    }

    /**
     * @param extAcctRenameStatus to set the extAcctRenameStatus
     */
    public void setExtAcctRenameStatus(@Nullable String extAcctRenameStatus) {
        this.extAcctRenameStatus = extAcctRenameStatus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FolderBaseBean{");
        sb.append("id=").append(id);
        sb.append("  name='").append(name).append('\'');
        sb.append("  messageExpiration=").append(messageExpiration);
        sb.append("  acctId=").append(acctId);
        sb.append("  type=").append(type);
        sb.append("  deletedId=").append(deletedId);
        sb.append("  extAcctUidNext=").append(extAcctUidNext);
        sb.append("  extFidList=").append(extFidList);
        sb.append("  extAcctFolderName='").append(extAcctFolderName).append('\'');
        sb.append("  extAcctSyncState=").append(extAcctSyncState);
        sb.append("  extAcctUidValidity=").append(extAcctUidValidity);
        sb.append("  extAccOldCycleRev=").append(extAccOldCycleRev);
        sb.append("  extFolderId=").append(extFolderId);
        sb.append("  size=").append(size);
        sb.append("  count=").append(count);
        sb.append("  unseen=").append(unseen);
        sb.append("  highestModSeq=").append(highestModSeq);
        sb.append("  uidNext=").append(uidNext);
        sb.append("  uidValidity=").append(uidValidity);
        sb.append("  extAcctRenameStatus='").append(extAcctRenameStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
