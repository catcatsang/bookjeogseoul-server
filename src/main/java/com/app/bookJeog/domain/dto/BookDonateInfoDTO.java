package com.app.bookJeog.domain.dto;

import com.app.bookJeog.domain.enumeration.BookReceivedStatus;
import com.app.bookJeog.domain.vo.BookDonateVO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString

public class BookDonateInfoDTO {
    private BookDonateDTO bookDonateDTO;
    private String imageUrl;
    private String author;


}
