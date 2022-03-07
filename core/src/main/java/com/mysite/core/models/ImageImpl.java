package com.mysite.core.models;


import com.adobe.cq.wcm.core.components.commons.link.Link;
import com.adobe.cq.wcm.core.components.models.Image;
import com.adobe.cq.wcm.core.components.models.ImageArea;
import com.adobe.cq.wcm.core.components.models.datalayer.ImageData;



import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import java.util.List;

@Model(adapters = {CustomImage.class, Image.class}, resourceType = ImageImpl.resourceType, adaptables = SlingHttpServletRequest.class)
public class ImageImpl implements CustomImage {

    public static final String resourceType = "interviewsite/components/image";


    @Self
    @Via(type = ResourceSuperType.class)
    private Image image;


    @ValueMapValue
    private String fileReferenceThumbnail;

    public String getFileReferenceThumbnail() {
        return fileReferenceThumbnail;
    }

    @Override
    public String getTitle() {
        return image.getTitle();
    }


    @Override
    public String getSrc() {
        return image.getSrc();
    }

    @Override
    public String getAlt() {
        return image.getAlt();
    }

    @Override
    public String getUuid() {
        return image.getUuid();
    }

    @Override
    public Link getImageLink() {
        return image.getImageLink();
    }

    @Override
    @Deprecated
    public String getLink() {
        return image.getLink();
    }

    @Override
    public boolean displayPopupTitle() {
        return image.displayPopupTitle();
    }

    @Override
    
    public String getFileReference() {
        return image.getFileReference();
    }

    @Override
    
    @Deprecated
    public String getJson() {
        return image.getJson();
    }

    @Override
    public int[] getWidths() {
        return image.getWidths();
    }

    @Override
    public String getSrcUriTemplate() {
        return image.getSrcUriTemplate();
    }

    @Override
    public boolean isLazyEnabled() {
        return image.isLazyEnabled();
    }

    @Override
    public String getSrcset() {
        return image.getSrcset();
    }

    @Override
    public String getWidth() {
        return image.getWidth();
    }

    @Override
    public String getHeight() {
        return image.getHeight();
    }

    @Override
    public int getLazyThreshold() {
        return image.getLazyThreshold();
    }

    @Override
    public List<ImageArea> getAreas() {
        return image.getAreas();
    }

    @Override
    public boolean isDecorative() {
        return image.isDecorative();
    }

    @Override
    public String getSmartCropRendition() {
        return image.getSmartCropRendition();
    }

    @Override
    public boolean isDmImage() {
        return image.isDmImage();
    }

    @Override
    public ImageData getComponentData() {
        return image.getComponentData();
    }
}
