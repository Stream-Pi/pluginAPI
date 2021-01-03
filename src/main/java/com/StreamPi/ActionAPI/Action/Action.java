/*
ActionAPI for StreamPi
Written by Debayan Sutradhar (dubbadhar)
 */
package com.StreamPi.ActionAPI.Action;

import com.StreamPi.ActionAPI.ActionProperty.ClientProperties;
import com.StreamPi.ActionAPI.ActionProperty.ServerProperties;
import com.StreamPi.Util.Version.Version;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.text.Font;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.Serializable;
import java.util.UUID;

public class Action implements Cloneable, Serializable {
    private ActionType actionType;
    private String name, ID;
    private Version version;
    private byte[] icon = null;
    private boolean hasIcon = false;
    private Location location = null;
    private boolean showIcon = false;
    private String parent = null;

    private static final DataFormat dataFormat = new DataFormat("com.StreamPi.ActionAPI.Action");

    public static DataFormat getDataFormat() {
        return dataFormat;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    private String displayTextFontColourHex = null;
    private String bgColourHex = null;

    private String displayText = null;
    private boolean showDisplayText = true;
    private DisplayTextAlignment displayTextAlignment = DisplayTextAlignment.CENTER;

    private Node serverButtonGraphic = null;

    private String repo = null;

    public String getRepo()
    {
        return repo;
    }

    public void setRepo(String repo)
    {
        this.repo = repo;
    }

    private ServerProperties serverProperties;
    private ClientProperties clientProperties;
    private String category;

    public String moduleName;

    public boolean invalid;

    public Action(String name, String ID, ActionType actionType)
    {
        this.serverProperties = new ServerProperties();
        this.clientProperties = new ClientProperties();
        this.name = name;
        setCategory("Others");
        this.ID = ID;
        this.actionType = actionType;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public void setShowDisplayText(boolean showDisplayText) {
        this.showDisplayText = showDisplayText;
    }

    public void setDisplayTextAlignment(DisplayTextAlignment displayTextAlignment) {
        this.displayTextAlignment = displayTextAlignment;
    }


    public void setDisplayTextFontColourHex(String displayTextFontColourHex) {
        this.displayTextFontColourHex = displayTextFontColourHex;
    }

    public String getDisplayTextFontColourHex() {
        return displayTextFontColourHex;
    }

    public void setBgColourHex(String bgColourHex) {
        this.bgColourHex = bgColourHex;
    }

    public String getBgColourHex() {
        return bgColourHex;
    }

    public DisplayTextAlignment getDisplayTextAlignment() {
        return displayTextAlignment;
    }

    public String getDisplayText() {
        return displayText;
    }

    public boolean isShowDisplayText()
    {
        return showDisplayText;
    }

    public void setServerButtonGraphic(String iconName)
    {
        try
        {
            this.serverButtonGraphic = new FontIcon(iconName);
        }
        catch (Exception e)
        {
            this.serverButtonGraphic = null;
            
        }
    }

    public void setServerButtonGraphic(ImageView graphic)
    {
        this.serverButtonGraphic = graphic;
    }

    public Node getServerButtonGraphic()
    {
        return serverButtonGraphic;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public Action(String ID, ActionType actionType)
    {
        this.serverProperties = new ServerProperties();
        this.clientProperties = new ClientProperties();
        this.category = "Others";
        this.ID = ID;
        this.actionType = actionType;
    }

    public Action(ActionType actionType)
    {
        this.serverProperties = new ServerProperties();
        this.clientProperties = new ClientProperties();
        setCategory("Others");
        this.actionType = actionType;
    }

    public Action()
    {
        this.serverProperties = new ServerProperties();
    }

    public void setIDRandom()
    {
        setID(UUID.randomUUID().toString());
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getID()
    {
        return ID;
    }

    public void setClientProperties(ClientProperties properties)
    {
        this.clientProperties = properties;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public void setShowIcon(boolean value)
    {
        this.showIcon = value;
    }

    public boolean isShowIcon()
    {
        return showIcon;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setIcon(byte[] icon)
    {
        this.hasIcon = true;
        this.icon = icon;
    }

    public boolean isHasIcon()
    {
        return hasIcon;
    }

    public void setHasIcon(boolean hasIcon) {
        this.hasIcon = hasIcon;
    }

    public byte[] getIconAsByteArray() {
        return icon;
    }

    public ServerProperties getServerProperties()
    {
        return serverProperties;
    }

    public ClientProperties getClientProperties()
    {
        return clientProperties;
    }

    public String getModuleName()
    {
        return moduleName;
    }


    public void setVersion(Version version)
    {
        this.version = version;
    }

    public Version getVersion()
    {
        return version;
    }

    public Action clone() throws CloneNotSupportedException {
        Action action = (Action) super.clone();
        action.setClientProperties((ClientProperties) action.getClientProperties().clone());
        return action;
    }

    private ServerPropertySaver serverPropertySaver = null;

    public void setServerPropertySaver(ServerPropertySaver serverPropertySaver)
    {
        this.serverPropertySaver = serverPropertySaver;
    }

    public void saveServerProperties()
    {
        serverPropertySaver.saveServerProperties();
    }

    
    private ServerConnection serverConnection = null;

    public void setServerConnection(ServerConnection serverConnection)
    {
        this.serverConnection = serverConnection;
    }

    public ServerConnection getServerConnection()
    {
        return serverConnection;
    }
}
