package com.padr.buynow.domain.usecase.product.producttypeattribute.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.producttypeattribute.model.UpdateProductTypeAttributeUseCaseModel;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.impl.CreateProductTypeAttributeValue;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.impl.DeleteProductTypeAttributeValue;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.impl.UpdateProductTypeAttributeValue;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.model.CreateProductTypeAttributeValueUseCaseModel;
import com.padr.buynow.domain.usecase.product.producttypeattributevalue.model.UpdateProductTypeAttributeValueUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductTypeAttribute
        implements BaseUseCase<ProductTypeAttribute, UpdateProductTypeAttributeUseCaseModel> {

    private final ProductTypeAttributeService productTypeAttributeService;

    private final UpdateProductTypeAttributeValue updateProductTypeAttributeValue;
    private final CreateProductTypeAttributeValue createProductTypeAttributeValue;
    private final DeleteProductTypeAttributeValue deleteProductTypeAttributeValue;

    @Override
    public ProductTypeAttribute perform(UpdateProductTypeAttributeUseCaseModel model) {
        ProductTypeAttribute productTypeAttribute = productTypeAttributeService.findById(model.getId());

        List<UpdateProductTypeAttributeValueUseCaseModel> updateValueModels = new ArrayList<>();
        List<CreateProductTypeAttributeValueUseCaseModel> createValueModels = new ArrayList<>();

        productTypeAttribute.getProductTypeAttributeValues().parallelStream().forEach(v -> {
            Optional<UpdateProductTypeAttributeValueUseCaseModel> valueModelOptional = model.getValueModels()
                    .parallelStream().filter(valueModel -> valueModel.getId().equals(v.getId())).findAny();

            if (!valueModelOptional.isPresent())
                deleteProductTypeAttributeValue.perform(v.getId());
        });

        model.getValueModels().parallelStream().forEach(v -> {
            if (Objects.isNull(v.getId())) {
                CreateProductTypeAttributeValueUseCaseModel valueModel = CreateProductTypeAttributeValueUseCaseModel
                        .builder().value(v.getValue())
                        .productTypeAttributeId(model.getId())
                        .build();

                createValueModels.add(valueModel);
            } else {
                UpdateProductTypeAttributeValueUseCaseModel valueModel = UpdateProductTypeAttributeValueUseCaseModel
                        .builder()
                        .id(v.getId())
                        .value(v.getValue())
                        .build();

                updateValueModels.add(valueModel);
            }
        });

        createProductTypeAttributeValue.perform(createValueModels);
        updateProductTypeAttributeValue.perform(updateValueModels);

        return productTypeAttributeService.update(model.getId(), model.to());
    }
}
