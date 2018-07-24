
package br.com.linkup.model.team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "canComplete",
    "project-id",
    "creator-lastname",
    "has-reminders",
    "todo-list-name",
    "has-unread-comments",
    "due-date-base",
    "order",
    "comments-count",
    "private",
    "status",
    "todo-list-id",
    "predecessors",
    "created-on",
    "canEdit",
    "content",
    "has-predecessors",
    "company-name",
    "id",
    "creator-firstname",
    "last-changed-on",
    "due-date",
    "has-dependencies",
    "completed",
    "position",
    "attachments-count",
    "estimated-minutes",
    "description",
    "boardColumn",
    "priority",
    "progress",
    "harvest-enabled",
    "viewEstimatedTime",
    "parentTaskId",
    "company-id",
    "tasklist-lockdownId",
    "creator-avatar-url",
    "canLogTime",
    "creator-id",
    "project-name",
    "attachments",
    "start-date",
    "parent-task",
    "tasklist-private",
    "timeIsLogged",
    "lockdownId",
    "tags"
})
public class TodoItem {

    @JsonProperty("canComplete")
    private Boolean canComplete;
    @JsonProperty("project-id")
    private String projectId;
    @JsonProperty("creator-lastname")
    private String creatorLastname;
    @JsonProperty("has-reminders")
    private Boolean hasReminders;
    @JsonProperty("todo-list-name")
    private String todoListName;
    @JsonProperty("has-unread-comments")
    private Boolean hasUnreadComments;
    @JsonProperty("due-date-base")
    private String dueDateBase;
    @JsonProperty("order")
    private String order;
    @JsonProperty("comments-count")
    private String commentsCount;
    @JsonProperty("private")
    private String _private;
    @JsonProperty("status")
    private String status;
    @JsonProperty("todo-list-id")
    private String todoListId;
    @JsonProperty("predecessors")
    private List<Object> predecessors = null;
    @JsonProperty("created-on")
    private String createdOn;
    @JsonProperty("canEdit")
    private Boolean canEdit;
    @JsonProperty("content")
    private String content;
    @JsonProperty("has-predecessors")
    private String hasPredecessors;
    @JsonProperty("company-name")
    private String companyName;
    @JsonProperty("id")
    private String id;
    @JsonProperty("creator-firstname")
    private String creatorFirstname;
    @JsonProperty("last-changed-on")
    private String lastChangedOn;
    @JsonProperty("due-date")
    private String dueDate;
    @JsonProperty("has-dependencies")
    private String hasDependencies;
    @JsonProperty("completed")
    private Boolean completed;
    @JsonProperty("position")
    private String position;
    @JsonProperty("attachments-count")
    private String attachmentsCount;
    @JsonProperty("estimated-minutes")
    private String estimatedMinutes;
    @JsonProperty("description")
    private String description;
    @JsonProperty("boardColumn")
    private List<BoardColumn> boardColumn = null;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("progress")
    private String progress;
    @JsonProperty("harvest-enabled")
    private Boolean harvestEnabled;
    @JsonProperty("viewEstimatedTime")
    private Boolean viewEstimatedTime;
    @JsonProperty("parentTaskId")
    private String parentTaskId;
    @JsonProperty("company-id")
    private String companyId;
    @JsonProperty("tasklist-lockdownId")
    private String tasklistLockdownId;
    @JsonProperty("creator-avatar-url")
    private String creatorAvatarUrl;
    @JsonProperty("canLogTime")
    private Boolean canLogTime;
    @JsonProperty("creator-id")
    private String creatorId;
    @JsonProperty("project-name")
    private String projectName;
    @JsonProperty("attachments")
    private List<Object> attachments = null;
    @JsonProperty("start-date")
    private String startDate;
    @JsonProperty("parent-task")
    private ParentTask parentTask;
    @JsonProperty("tasklist-private")
    private String tasklistPrivate;
    @JsonProperty("timeIsLogged")
    private String timeIsLogged;
    @JsonProperty("lockdownId")
    private String lockdownId;
    @JsonProperty("tags")
    private List<Tag> tags = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("canComplete")
    public Boolean getCanComplete() {
        return canComplete;
    }

    @JsonProperty("canComplete")
    public void setCanComplete(Boolean canComplete) {
        this.canComplete = canComplete;
    }

    @JsonProperty("project-id")
    public String getProjectId() {
        return projectId;
    }

    @JsonProperty("project-id")
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("creator-lastname")
    public String getCreatorLastname() {
        return creatorLastname;
    }

    @JsonProperty("creator-lastname")
    public void setCreatorLastname(String creatorLastname) {
        this.creatorLastname = creatorLastname;
    }

    @JsonProperty("has-reminders")
    public Boolean getHasReminders() {
        return hasReminders;
    }

    @JsonProperty("has-reminders")
    public void setHasReminders(Boolean hasReminders) {
        this.hasReminders = hasReminders;
    }

    @JsonProperty("todo-list-name")
    public String getTodoListName() {
        return todoListName;
    }

    @JsonProperty("todo-list-name")
    public void setTodoListName(String todoListName) {
        this.todoListName = todoListName;
    }

    @JsonProperty("has-unread-comments")
    public Boolean getHasUnreadComments() {
        return hasUnreadComments;
    }

    @JsonProperty("has-unread-comments")
    public void setHasUnreadComments(Boolean hasUnreadComments) {
        this.hasUnreadComments = hasUnreadComments;
    }

    @JsonProperty("due-date-base")
    public String getDueDateBase() {
        return dueDateBase;
    }

    @JsonProperty("due-date-base")
    public void setDueDateBase(String dueDateBase) {
        this.dueDateBase = dueDateBase;
    }

    @JsonProperty("order")
    public String getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(String order) {
        this.order = order;
    }

    @JsonProperty("comments-count")
    public String getCommentsCount() {
        return commentsCount;
    }

    @JsonProperty("comments-count")
    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    @JsonProperty("private")
    public String getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(String _private) {
        this._private = _private;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("todo-list-id")
    public String getTodoListId() {
        return todoListId;
    }

    @JsonProperty("todo-list-id")
    public void setTodoListId(String todoListId) {
        this.todoListId = todoListId;
    }

    @JsonProperty("predecessors")
    public List<Object> getPredecessors() {
        return predecessors;
    }

    @JsonProperty("predecessors")
    public void setPredecessors(List<Object> predecessors) {
        this.predecessors = predecessors;
    }

    @JsonProperty("created-on")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("created-on")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("canEdit")
    public Boolean getCanEdit() {
        return canEdit;
    }

    @JsonProperty("canEdit")
    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("has-predecessors")
    public String getHasPredecessors() {
        return hasPredecessors;
    }

    @JsonProperty("has-predecessors")
    public void setHasPredecessors(String hasPredecessors) {
        this.hasPredecessors = hasPredecessors;
    }

    @JsonProperty("company-name")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("company-name")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("creator-firstname")
    public String getCreatorFirstname() {
        return creatorFirstname;
    }

    @JsonProperty("creator-firstname")
    public void setCreatorFirstname(String creatorFirstname) {
        this.creatorFirstname = creatorFirstname;
    }

    @JsonProperty("last-changed-on")
    public String getLastChangedOn() {
        return lastChangedOn;
    }

    @JsonProperty("last-changed-on")
    public void setLastChangedOn(String lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
    }

    @JsonProperty("due-date")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("due-date")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("has-dependencies")
    public String getHasDependencies() {
        return hasDependencies;
    }

    @JsonProperty("has-dependencies")
    public void setHasDependencies(String hasDependencies) {
        this.hasDependencies = hasDependencies;
    }

    @JsonProperty("completed")
    public Boolean getCompleted() {
        return completed;
    }

    @JsonProperty("completed")
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("attachments-count")
    public String getAttachmentsCount() {
        return attachmentsCount;
    }

    @JsonProperty("attachments-count")
    public void setAttachmentsCount(String attachmentsCount) {
        this.attachmentsCount = attachmentsCount;
    }

    @JsonProperty("estimated-minutes")
    public String getEstimatedMinutes() {
        return estimatedMinutes;
    }

    @JsonProperty("estimated-minutes")
    public void setEstimatedMinutes(String estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("boardColumn")
    public List<BoardColumn> getBoardColumn() {
        return boardColumn;
    }

    @JsonProperty("boardColumn")
    public void setBoardColumn(List<BoardColumn> boardColumn) {
        this.boardColumn = boardColumn;
    }

    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @JsonProperty("progress")
    public String getProgress() {
        return progress;
    }

    @JsonProperty("progress")
    public void setProgress(String progress) {
        this.progress = progress;
    }

    @JsonProperty("harvest-enabled")
    public Boolean getHarvestEnabled() {
        return harvestEnabled;
    }

    @JsonProperty("harvest-enabled")
    public void setHarvestEnabled(Boolean harvestEnabled) {
        this.harvestEnabled = harvestEnabled;
    }

    @JsonProperty("viewEstimatedTime")
    public Boolean getViewEstimatedTime() {
        return viewEstimatedTime;
    }

    @JsonProperty("viewEstimatedTime")
    public void setViewEstimatedTime(Boolean viewEstimatedTime) {
        this.viewEstimatedTime = viewEstimatedTime;
    }

    @JsonProperty("parentTaskId")
    public String getParentTaskId() {
        return parentTaskId;
    }

    @JsonProperty("parentTaskId")
    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    @JsonProperty("company-id")
    public String getCompanyId() {
        return companyId;
    }

    @JsonProperty("company-id")
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @JsonProperty("tasklist-lockdownId")
    public String getTasklistLockdownId() {
        return tasklistLockdownId;
    }

    @JsonProperty("tasklist-lockdownId")
    public void setTasklistLockdownId(String tasklistLockdownId) {
        this.tasklistLockdownId = tasklistLockdownId;
    }

    @JsonProperty("creator-avatar-url")
    public String getCreatorAvatarUrl() {
        return creatorAvatarUrl;
    }

    @JsonProperty("creator-avatar-url")
    public void setCreatorAvatarUrl(String creatorAvatarUrl) {
        this.creatorAvatarUrl = creatorAvatarUrl;
    }

    @JsonProperty("canLogTime")
    public Boolean getCanLogTime() {
        return canLogTime;
    }

    @JsonProperty("canLogTime")
    public void setCanLogTime(Boolean canLogTime) {
        this.canLogTime = canLogTime;
    }

    @JsonProperty("creator-id")
    public String getCreatorId() {
        return creatorId;
    }

    @JsonProperty("creator-id")
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @JsonProperty("project-name")
    public String getProjectName() {
        return projectName;
    }

    @JsonProperty("project-name")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @JsonProperty("attachments")
    public List<Object> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    @JsonProperty("start-date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start-date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("parent-task")
    public ParentTask getParentTask() {
        return parentTask;
    }

    @JsonProperty("parent-task")
    public void setParentTask(ParentTask parentTask) {
        this.parentTask = parentTask;
    }

    @JsonProperty("tasklist-private")
    public String getTasklistPrivate() {
        return tasklistPrivate;
    }

    @JsonProperty("tasklist-private")
    public void setTasklistPrivate(String tasklistPrivate) {
        this.tasklistPrivate = tasklistPrivate;
    }

    @JsonProperty("timeIsLogged")
    public String getTimeIsLogged() {
        return timeIsLogged;
    }

    @JsonProperty("timeIsLogged")
    public void setTimeIsLogged(String timeIsLogged) {
        this.timeIsLogged = timeIsLogged;
    }

    @JsonProperty("lockdownId")
    public String getLockdownId() {
        return lockdownId;
    }

    @JsonProperty("lockdownId")
    public void setLockdownId(String lockdownId) {
        this.lockdownId = lockdownId;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
