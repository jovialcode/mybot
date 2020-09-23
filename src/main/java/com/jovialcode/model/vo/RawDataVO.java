package com.jovialcode.model.vo;

import lombok.Getter;
import lombok.Setter;
import org.jsoup.nodes.Document;

/**
 * Description:
 *  - 수진된 로우 데이터
 */
@Getter
@Setter
public class RawDataVO {
    private String inputString;
    private Document inputDocument;
}
