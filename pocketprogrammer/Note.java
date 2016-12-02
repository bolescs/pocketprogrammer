package cameron.boles.android.pocketprogrammer;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Cameron Boles on 11/17/16.
 *
 * Class for the Note object.
 */

public class Note
{
    private UUID mId;
    private String mTitle;
    private String mBody;
    private Date mDate;
    private String mContact;

    public Note()
    {
        this(UUID.randomUUID());
    }

    public Note(UUID id)
    {
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getPhotoFilename()
    {
        return "IMG_" + getId().toString() + ".jpg";
    }

}
