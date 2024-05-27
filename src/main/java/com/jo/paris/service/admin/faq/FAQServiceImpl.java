package com.jo.paris.service.admin.faq;

import com.jo.paris.dto.FAQDto;
import com.jo.paris.entity.FAQ;
import com.jo.paris.entity.Product;
import com.jo.paris.repo.FAQRepository;
import com.jo.paris.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {

    private final FAQRepository faqRepository;

    private final ProductRepository productRepository;

    @Override
    public FAQDto postFAQ(Long productId, FAQDto faqDto) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            FAQ faq = new FAQ();
            faq.setQuestion(faqDto.getQuestion());
            faq.setAnswer(faqDto.getAnswer());
            faq.setProduct(optionalProduct.get());
            FAQ createdFaq = faqRepository.save(faq);
            FAQDto createdFaqDto = new FAQDto();
            createdFaqDto.setId(createdFaq.getId());
            return createdFaqDto;
        }
        return null;
    }
}
