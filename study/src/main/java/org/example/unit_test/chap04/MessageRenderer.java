package org.example.unit_test.chap04;

import java.util.List;

public class MessageRenderer implements IRenderer {

    private List<IRenderer> subRenderers;

    public MessageRenderer() {
        this.subRenderers = List.of(new HeaderRenderer(), new BodyRenderer(), new FooterRenderer());
    }

    @Override
    public String render(final Message message) {
        StringBuilder renderedBuilder = new StringBuilder();
        for (IRenderer subRenderer : subRenderers) {
            renderedBuilder.append(subRenderer.render(message));
        }
        return renderedBuilder.toString();
    }

    public List<IRenderer> subRenderers() {
        return subRenderers.stream()
                .toList();
    }

}
