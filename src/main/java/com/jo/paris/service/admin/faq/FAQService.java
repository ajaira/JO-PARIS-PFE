package com.jo.paris.service.admin.faq;

import com.jo.paris.dto.FAQDto;

public interface FAQService {
    FAQDto postFAQ(Long productId, FAQDto faqDto);
}
