package org.example.mime.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageBean {
    /**
     * AttachmentType
     */
    private List<String> attachmentType;
    /**
     * Lite DedupId
     */
    private Long liteDedupId;
    private String composeSessionId;
    /**
     * Compose Xpath
     */
    private String xPath;
    /**
     * Compose filterResult
     */
    private String filterResult;
    /**
     * Schema Search Data
     */
    private String schemaSearchData;
    /**
     * DeliveryId
     */
    private String deliveryId;
    /**
     * snippet
     */
    private String snippet;
    /**
     * qtpSubHash
     */
    private String qtpSubjectHash;
    /**
     * qtpTokenLength
     */
    private Long qtpTokenLength;
    /**
     * qtpCrc
     */
    private Long qtpCrc;
    /**
     * Crc
     */
    private Long crc;
    /**
     * MimeDate
     */
    private Long mimeDate;
    /**
     * mimeType
     */
    private String mimeType;
    /**
     * VerifiedDomains
     */
    private JsonNode verifiedDomains;
    private String inReplyToReference;
    /**
     * inboxServices
     */
    private String inboxServices;
    private Integer folderId;
    private String mimeId;
    private Long size;
    private Long internalDate;
    private Long dedupId;
    private Map<String, Boolean> flags;
    private String fromEmail;
    private List<String> toAddr;
    private String subject;
    private Integer acctId;
    private Integer threadId;
    private Integer uid;
    private Long auid;
    /**
     * ymumId
     */
    private String ymumId;
    private Long deleteTsSec;
    private String prevFolder;

    /**
     * Body search field.
     */
    private SearchData searchData;
    /**
     * decoNum
     */
    @JsonProperty("decoNum")
    private List<Integer> decoNum;
    /**
     * decos
     */
    @JsonProperty("decos")
    private List<String> decos;
    /**
     * schema Org
     */
    @JsonProperty("schemaOrg")
    private JsonNode schemaOrg;
    /**
     * Boolean restore Message
     */
    @JsonProperty("restoreMessage")
    private Boolean restoreMessage;
    /**
     * purge time stamp
     */
    private Long purgeTsSec;
    @JsonProperty("references")
    private List<String> references;
    /**
     * references Real
     */
    @JsonProperty("referencesReal")
    private List<String> referencesReal;
    /**
     * in Reply To
     */
    @JsonProperty("inReplyTo")
    private String inReplyTo;
    /**
     * send Count
     */
    @JsonProperty("sendCount")
    private Integer sendCount;
    /**
     * send Status
     */
    @JsonProperty("sendStatus")
    private Long sendStatus;
    /**
     * spam Check Result
     */
    @JsonProperty("spamCheckResult")
    private String spamCheckResult;
    /**
     * spam Check Token
     */
    @JsonProperty("spamCheckToken")
    private String spamCheckToken;
    /**
     * encryption Key
     */
    @JsonProperty("encryptionKey")
    private JsonNode encryptionKey;
    /**
     * extMsgId
     */
    private String extMsgId;
    /**
     * extFidUid
     */
    private String extFidUid;
    /**
     * extFlags
     */
    private Long extFlags;
    /**
     * extUidl
     */
    private String extUidl;
    /**
     * extAcctSyncState
     */
    private JsonNode extAcctSyncState;
    private Long enhancedChangeTsMs;
    private Long externalChangeTsMs;
    /**
     * changeTsMs
     */
    private Long changeTsMs;
    /**
     * in ccAddr To
     */
    private List<String> ccAddr;
    /**
     * in bccAddr To
     */
    private List<String> bccAddr;
    /**
     * SmtpRcptToAddr
     */
    private List<String> smtpRcptToAddr;
    /**
     * fromName Value
     */
    private String fromName;
    /**
     * xapparentlyto
     */
    private String xApparentlyTo;
    /**
     * IsPartial
     */
    private Boolean isPartial;
    /**
     * inReplyToReplied
     */
    private Boolean inReplyToReplied;
    /**
     * inReplyToFwded
     */
    private Boolean inReplyToFwded;
    /**
     * mimeIdReal
     */
    private String mimeIdReal;
    /**
     * attachments
     */
    private JsonNode attachments;
    @JsonIgnore
    private String detachedAttachments;
    /**
     * ReplyToAddr
     */
    private List<String> replyToAddr;
    /**
     * Recipient.
     */
    private String recipient;

    private Long creationTsMs;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getMimeId() {
        return mimeId;
    }

    public void setMimeId(String mimeId) {
        this.mimeId = mimeId;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Long getAuid() {
        return auid;
    }

    public void setAuid(Long auid) {
        this.auid = auid;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    /**
     * Gets detached attachments.
     *
     * @return the detached attachments
     */
    @JsonIgnore
    public String getDetachedAttachments() {
        return detachedAttachments;
    }

    /**
     * Sets detached attachments.
     *
     * @param detachedAttachments the detached attachments
     */
    public void setDetachedAttachments(String detachedAttachments) {
        this.detachedAttachments = detachedAttachments;
    }

    /**
     * @return ymumId
     */
    public String getYmumId() {
        return ymumId;
    }

    /**
     * @param ymumId
     */
    public void setYmumId(String ymumId) {
        this.ymumId = ymumId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getDeleteTsSec() {
        return deleteTsSec;
    }

    public void setDeleteTsSec(Long deleteTsSec) {
        this.deleteTsSec = deleteTsSec;
    }

    public String getPrevFolder() {
        return prevFolder;
    }

    public void setPrevFolder(String prevFolder) {
        this.prevFolder = prevFolder;
    }

    public Long getInternalDate() {
        return internalDate;
    }

    public void setInternalDate(Long internalDate) {
        this.internalDate = internalDate;
    }

    public Long getDedupId() {
        return dedupId;
    }

    public void setDedupId(Long dedupId) {
        this.dedupId = dedupId;
    }

    public Map<String, Boolean> getFlags() {
        return flags;
    }

    public void setFlags(Map<String, Boolean> flags) {
        this.flags = flags;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public List<String> getToAddr() {
        return toAddr;
    }

    public void setToAddr(List<String> toAddr) {
        this.toAddr = toAddr;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return decoNum
     */
    public List<Integer> getDecoNum() {
        return decoNum;
    }

    /**
     * @param decoNum decoNum list
     */
    public void setDecoNum(final List<Integer> decoNum) {
        this.decoNum = decoNum;
    }

    /**
     * @return decos
     */
    public List<String> getDecos() {
        return decos;
    }

    /**
     * @param decos decos list
     */
    public void setDecos(final List<String> decos) {
        this.decos = decos;
    }

    /**
     * @return schemaOrg
     */
    public JsonNode getSchemaOrg() {
        return schemaOrg;
    }

    /**
     * @param schemaOrg schema Org
     */
    public void setSchemaOrg(final JsonNode schemaOrg) {
        this.schemaOrg = schemaOrg;
    }

    /**
     * @return restoreMessage restore Message flag
     */
    public Boolean getRestoreMessage() {
        return restoreMessage;
    }

    /**
     * @param restoreMessage restoreMessage
     */
    public void setRestoreMessage(final Boolean restoreMessage) {
        this.restoreMessage = restoreMessage;
    }

    /**
     * @return purgeTsSec
     */
    public Long getPurgeTsSec() {
        return purgeTsSec;
    }

    /**
     * @param purgeTsSec purge Timestamp
     */
    public void setPurgeTsSec(final Long purgeTsSec) {
        this.purgeTsSec = purgeTsSec;
    }

    /**
     * @return referencesReal
     */
    public List<String> getReferencesReal() {
        return referencesReal;
    }

    /**
     * @param referencesReal references Real
     */
    public void setReferencesReal(final List<String> referencesReal) {
        this.referencesReal = referencesReal;
    }

    /**
     * @return references
     */
    public List<String> getReferences() {
        return references;
    }

    /**
     * @param references
     */
    public void setReferences(final List<String> references) {
        this.references = references;
    }

    /**
     * @return inReplyTo
     */
    public String getInReplyTo() {
        return inReplyTo;
    }

    /**
     * @param inReplyTo inReply To
     */
    public void setInReplyTo(final String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    /**
     * @return sendCount
     */
    public Integer getSendCount() {
        return sendCount;
    }

    /**
     * @param sendCount send Count
     */
    public void setSendCount(final Integer sendCount) {
        this.sendCount = sendCount;
    }

    /**
     * @return sendStatus
     */
    public Long getSendStatus() {
        return sendStatus;
    }

    /**
     * @param sendStatus send Status
     */
    public void setSendStatus(final Long sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * @return spamCheckResult
     */
    public String getSpamCheckResult() {
        return spamCheckResult;
    }

    /**
     * @param spamCheckResult spam Check Result
     */
    public void setSpamCheckResult(final String spamCheckResult) {
        this.spamCheckResult = spamCheckResult;
    }

    /**
     * @return spamCheckToken
     */
    public String getSpamCheckToken() {
        return spamCheckToken;
    }

    /**
     * @param spamCheckToken spam Check Token
     */
    public void setSpamCheckToken(final String spamCheckToken) {
        this.spamCheckToken = spamCheckToken;
    }

    /**
     * @return encryptionKey
     */
    public JsonNode getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * @param encryptionKey encryption Key
     */
    public void setEncryptionKey(final JsonNode encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    /**
     * @return the extMsgId
     */
    public String getExtMsgId() {
        return extMsgId;
    }

    /**
     * @param extMsgId
     */
    public void setExtMsgId(String extMsgId) {
        this.extMsgId = extMsgId;
    }

    /**
     * @return the extFidUid
     */
    public String getExtFidUid() {
        return extFidUid;
    }

    /**
     * @param extFidUid the extFidUid to set
     */
    public void setExtFidUid(String extFidUid) {
        this.extFidUid = extFidUid;
    }

    /**
     * @return the extFlags
     */
    public Long getExtFlags() {
        return extFlags;
    }

    /**
     * @param extFlags the extFlags to set
     */
    public void setExtFlags(Long extFlags) {
        this.extFlags = extFlags;
    }

    /**
     * @return the extUidl
     */
    public String getExtUidl() {
        return extUidl;
    }

    /**
     * @param extUidl the extUidl to set
     */
    public void setExtUidl(String extUidl) {
        this.extUidl = extUidl;
    }

    /**
     * @return the extAcctSyncState
     */
    public JsonNode getExtAcctSyncState() {
        return extAcctSyncState;
    }

    /**
     * @param extAcctSyncState the extAcctSyncState to set
     */
    public void setExtAcctSyncState(JsonNode extAcctSyncState) {
        this.extAcctSyncState = extAcctSyncState;
    }

    /**
     * @return isPartial value
     */
    public Boolean getIsPartial() {
        return isPartial;
    }

    /**
     * @param isPartial isPartial
     */
    public void setIsPartial(final Boolean isPartial) {
        this.isPartial = isPartial;
    }

    /**
     * @return inReplyToReplied
     */
    public Boolean getInReplyToReplied() {
        return inReplyToReplied;
    }

    /**
     * @param inReplyToReplied
     */
    public void setInReplyToReplied(final Boolean inReplyToReplied) {
        this.inReplyToReplied = inReplyToReplied;
    }

    /**
     * @return inReplyToFwded value
     */
    public Boolean getInReplyToFwded() {
        return inReplyToFwded;
    }

    /**
     * @param inReplyToFwded
     */
    public void setInReplyToFwded(final Boolean inReplyToFwded) {
        this.inReplyToFwded = inReplyToFwded;
    }

    /**
     * @return mimeIdReal value
     */
    public String getMimeIdReal() {
        return mimeIdReal;
    }

    /**
     * @param mimeIdReal
     */
    public void setMimeIdReal(String mimeIdReal) {
        this.mimeIdReal = mimeIdReal;
    }

    /**
     * @return attachmentType
     */
    public List<String> getAttachmentType() {
        return attachmentType;
    }

    /**
     * @param attachmentType
     */
    public void setAttachmentType(List<String> attachmentType) {
        this.attachmentType = attachmentType;
    }

    /**
     * @return attachments
     */
    public JsonNode getAttachments() {
        return attachments;
    }

    /**
     * @param attachments
     */
    public void setAttachments(final JsonNode attachments) {
        this.attachments = attachments;
    }

    /**
     * @return the enhancedChangeTsMs
     */
    public Long getEnhancedChangeTsMs() {
        return enhancedChangeTsMs;
    }

    /**
     * @param enhancedChangeTsMs
     */
    public void setEnhancedChangeTsMs(Long enhancedChangeTsMs) {
        this.enhancedChangeTsMs = enhancedChangeTsMs;
    }

    public Long getExternalChangeTsMs() {
        return externalChangeTsMs;
    }

    public void setExternalChangeTsMs(Long externalChangeTsMs) {
        this.externalChangeTsMs = externalChangeTsMs;
    }

    public Long getChangeTsMs() {
        return changeTsMs;
    }

    public void setChangeTsMs(Long changeTsMs) {
        this.changeTsMs = changeTsMs;
    }

    /**
     * @return ccAddr
     */
    public List<String> getCcAddr() {
        return ccAddr;
    }

    /**
     * @param ccAddr inReply To
     */
    public void setCcAddr(List<String> ccAddr) {
        this.ccAddr = ccAddr;
    }

    /**
     * @return bccAddr
     */
    public List<String> getBccAddr() {
        return bccAddr;
    }

    /**
     * @param bccAddr inReply To
     */
    public void setBccAddr(List<String> bccAddr) {
        this.bccAddr = bccAddr;
    }

    /**
     * @return fromName value
     */
    public String getFromName() {
        return fromName;
    }

    /**
     * @param fromName value
     */
    public void setFromName(final String fromName) {
        this.fromName = fromName;
    }

    /**
     * @return replyToAddr
     */
    public List<String> getReplyToAddr() {
        return replyToAddr;
    }

    /**
     * @param replyToAddr
     */
    public void setReplyToAddr(List<String> replyToAddr) {
        this.replyToAddr = replyToAddr;
    }

    /**
     * @return liteDedupId
     */
    public Long getLiteDedupId() {
        return liteDedupId;
    }

    /**
     * @param liteDedupId send Status
     */
    public void setLiteDedupId(final Long liteDedupId) {
        this.liteDedupId = liteDedupId;
    }

    /**
     * @return composeSid value
     */
    public String getComposeSessionId() {
        return composeSessionId;
    }

    /**
     * @param composeSessionId value
     */
    public void setComposeSessionId(final String composeSessionId) {
        this.composeSessionId = composeSessionId;
    }

    /**
     * @return xPath value
     */
    public String getxPath() {
        return xPath;
    }

    /**
     * @param xPath value
     */
    public void setxPath(final String xPath) {
        this.xPath = xPath;
    }

    /**
     * @return schemaSearchData value
     */
    public String getSchemaSearchData() {
        return schemaSearchData;
    }

    /**
     * @param schemaSearchData
     */
    public void setSchemaSearchData(String schemaSearchData) {
        this.schemaSearchData = schemaSearchData;
    }

    /**
     * @return filterResult value
     */
    public String getFilterResult() {
        return filterResult;
    }

    /**
     * @param filterResult
     */
    public void setFilterResult(String filterResult) {
        this.filterResult = filterResult;
    }

    /**
     * @return the deliveryId
     */
    public String getDeliveryId() {
        return deliveryId;
    }

    /**
     * @param deliveryId
     */
    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    /**
     * @return the snippet
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * @param snippet
     */
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    /**
     * @return the qtpSubjectHash
     */
    public String getQtpSubjectHash() {
        return qtpSubjectHash;
    }

    /**
     * @param qtpSubjectHash
     */
    public void setQtpSubjectHash(String qtpSubjectHash) {
        this.qtpSubjectHash = qtpSubjectHash;
    }

    /**
     * @return the qtpTokenLength
     */
    public Long getQtpTokenLength() {
        return qtpTokenLength;
    }

    /**
     * @param qtpTokenLength
     */
    public void setQtpTokenLength(final Long qtpTokenLength) {
        this.qtpTokenLength = qtpTokenLength;
    }

    /**
     * @return crc
     */
    public Long getCrc() {
        return crc;
    }

    /**
     * @param crc
     */
    public void setCrc(final Long crc) {
        this.crc = crc;
    }

    /**
     * @return qtpCrc
     */
    public Long getQtpCrc() {
        return qtpCrc;
    }

    /**
     * @param qtpCrc
     */
    public void setQtpCrc(final Long qtpCrc) {
        this.qtpCrc = qtpCrc;
    }

    /**
     * @return mimeDate
     */
    public Long getMimeDate() {
        return mimeDate;
    }

    /**
     * @param mimeDate
     */
    public void setMimeDate(Long mimeDate) {
        this.mimeDate = mimeDate;
    }

    /**
     * @return mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @param mimeType
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * @return verifiedDomains
     */
    public JsonNode getVerifiedDomains() {
        return verifiedDomains;
    }

    /**
     * @param verifiedDomains
     */
    public void setVerifiedDomains(JsonNode verifiedDomains) {
        this.verifiedDomains = verifiedDomains;
    }

    /**
     * @return smtpRcptToAddr
     */
    public List<String> getSmtpRcptToAddr() {
        return smtpRcptToAddr;
    }

    /**
     * @param smtpRcptToAddr
     */
    public void setSmtpRcptToAddr(List<String> smtpRcptToAddr) {
        this.smtpRcptToAddr = smtpRcptToAddr;
    }

    /**
     * @return inReplyToReference
     */
    public String getInReplyToReference() {
        return inReplyToReference;
    }

    /**
     * @param inReplyToReference
     */
    public void setInReplyToReference(String inReplyToReference) {
        this.inReplyToReference = inReplyToReference;
    }

    /**
     * @return inboxServices
     */
    public String getInboxServices() {
        return inboxServices;
    }

    /**
     * @param inboxServices
     */
    public void setInboxServices(String inboxServices) {
        this.inboxServices = inboxServices;
    }

    /**
     * @return xApparentlyTo
     */
    public String getxApparentlyTo() {
        return xApparentlyTo;
    }

    /**
     * @param xApparentlyTo
     */
    public void setxApparentlyTo(String xApparentlyTo) {
        this.xApparentlyTo = xApparentlyTo;
    }

    /**
     * @return body search field.
     */
    public SearchData getSearchData() {
        return searchData;
    }

    /**
     * Set the searchData field.
     *
     * @param searchData bodySearch field
     */
    public void setSearchData(SearchData searchData) {
        this.searchData = searchData;
    }

    public Long getCreationTsMs() {
        return creationTsMs;
    }

    public void setCreationTsMs(Long creationTsMs) {
        this.creationTsMs = creationTsMs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageBean{");
        sb.append("attachmentType=").append(attachmentType);
        sb.append(", liteDedupId=").append(liteDedupId);
        sb.append(", composeSessionId='").append(composeSessionId).append('\'');
        sb.append(", xPath='").append(xPath).append('\'');
        sb.append(", filterResult='").append(filterResult).append('\'');
        sb.append(", schemaSearchData='").append(schemaSearchData).append('\'');
        sb.append(", deliveryId='").append(deliveryId).append('\'');
        sb.append(", snippet='").append(snippet).append('\'');
        sb.append(", qtpSubjectHash='").append(qtpSubjectHash).append('\'');
        sb.append(", qtpTokenLength=").append(qtpTokenLength);
        sb.append(", qtpCrc=").append(qtpCrc);
        sb.append(", crc=").append(crc);
        sb.append(", mimeDate=").append(mimeDate);
        sb.append(", mimeType='").append(mimeType).append('\'');
        sb.append(", verifiedDomains=").append(verifiedDomains);
        sb.append(", inReplyToReference='").append(inReplyToReference).append('\'');
        sb.append(", inboxServices='").append(inboxServices).append('\'');
        sb.append(", folderId=").append(folderId);
        sb.append(", mimeId='").append(mimeId).append('\'');
        sb.append(", size=").append(size);
        sb.append(", internalDate=").append(internalDate);
        sb.append(", dedupId=").append(dedupId);
        sb.append(", flags=").append(flags);
        sb.append(", fromEmail='").append(fromEmail).append('\'');
        sb.append(", toAddr=").append(toAddr);
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", acctId=").append(acctId);
        sb.append(", threadId=").append(threadId);
        sb.append(", uid=").append(uid);
        sb.append(", auid=").append(auid);
        sb.append(", ymumId='").append(ymumId).append('\'');
        sb.append(", decoNum=").append(decoNum);
        sb.append(", decos=").append(decos);
        sb.append(", schemaOrg=").append(schemaOrg);
        sb.append(", restoreMessage=").append(restoreMessage);
        sb.append(", purgeTsSec=").append(purgeTsSec);
        sb.append(", references=").append(references);
        sb.append(", referencesReal=").append(referencesReal);
        sb.append(", inReplyTo='").append(inReplyTo).append('\'');
        sb.append(", sendCount=").append(sendCount);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", spamCheckResult='").append(spamCheckResult).append('\'');
        sb.append(", spamCheckToken='").append(spamCheckToken).append('\'');
        sb.append(", encryptionKey=").append(encryptionKey);
        sb.append(", extMsgId='").append(extMsgId).append('\'');
        sb.append(", extFidUid='").append(extFidUid).append('\'');
        sb.append(", extFlags=").append(extFlags);
        sb.append(", extUidl='").append(extUidl).append('\'');
        sb.append(", extAcctSyncState=").append(extAcctSyncState);
        sb.append(", enhancedChangeTsMs=").append(enhancedChangeTsMs);
        sb.append(", ccAddr=").append(ccAddr);
        sb.append(", bccAddr=").append(bccAddr);
        sb.append(", smtpRcptToAddr=").append(smtpRcptToAddr);
        sb.append(", fromName='").append(fromName).append('\'');
        sb.append(", xApparentlyTo='").append(xApparentlyTo).append('\'');
        sb.append(", isPartial=").append(isPartial);
        sb.append(", inReplyToReplied=").append(inReplyToReplied);
        sb.append(", inReplyToFwded=").append(inReplyToFwded);
        sb.append(", mimeIdReal='").append(mimeIdReal).append('\'');
        sb.append(", attachments=").append(attachments);
        sb.append(", replyToAddr=").append(replyToAddr);
        sb.append(", recipient='").append(recipient).append('\'');
        sb.append(", searchData='").append(searchData).append('\'');
        sb.append(", creationTsMs=").append(creationTsMs);
        sb.append('}');
        return sb.toString();
    }

}
