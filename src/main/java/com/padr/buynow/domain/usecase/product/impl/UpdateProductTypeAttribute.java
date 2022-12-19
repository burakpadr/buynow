package com.padr.buynow.domain.usecase.product.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.CreateProductTypeAttributeValueModel;
import com.padr.buynow.domain.usecase.product.model.UpdateProductTypeAttributeModel;
import com.padr.buynow.domain.usecase.product.model.UpdateProductTypeAttributeValueModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProductTypeAttribute
        implements BaseUseCase<ProductTypeAttribute, UpdateProductTypeAttributeModel> {

    private final ProductTypeAttributeService productTypeAttributeService;

    private final UpdateProductTypeAttributeValue updateProductTypeAttributeValue;
    private final CreateProductTypeAttributeValue createProductTypeAttributeValue;
    private final DeleteProductTypeAttributeValue deleteProductTypeAttributeValue;

    @Override
    public ProductTypeAttribute perform(UpdateProductTypeAttributeModel model) {
        ProductTypeAttribute productTypeAttribute = productTypeAttributeService.findById(model.getId());

        List<UpdateProductTypeAttributeValueModel> updateValueModels = new ArrayList<>();
        List<CreateProductTypeAttributeValueModel> createValueModels = new ArrayList<>();

        productTypeAttribute.getProductTypeAttributeValues().parallelStream().forEach(v -> {
            Optional<UpdateProductTypeAttributeValueModel> valueModelOptional = model.getValueModels()
                    .parallelStream().filter(valueModel -> valueModel.getId().equals(v.getId())).findAny();

            if (!valueModelOptional.isPresent())
                deleteProductTypeAttributeValue.perform(v.getId());
        });

        model.getValueModels().parallelStream().forEach(v -> {
            if (Objects.isNull(v.getId())) {
                CreateProductTypeAttributeValueModel valueModel = CreateProductTypeAttributeValueModel
                        .builder().value(v.getValue())
                        .productTypeAttributeId(model.getId())
                        .build();

                createValueModels.add(valueModel);
            } else {
                UpdateProductTypeAttributeValueModel valueModel = UpdateProductTypeAttributeValueModel
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
