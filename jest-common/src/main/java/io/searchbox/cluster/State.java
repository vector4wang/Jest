package io.searchbox.cluster;

import io.searchbox.action.AbstractAction;
import io.searchbox.action.GenericResultAbstractAction;

/**
 * @author Dogukan Sonmez
 * @author cihat keser
 */
public class State extends GenericResultAbstractAction {

    public State(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    @Override
    protected String buildURI() {
        StringBuilder sb = new StringBuilder(super.buildURI());
        sb.append("/_cluster/state");
        return sb.toString();
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    public static class Builder extends AbstractAction.Builder<State, Builder> {

        /**
         * Shows the cluster state version.
         */
        public Builder version() {
            return addCleanApiParameter("version");
        }

        /**
         * Shows the elected master_node part of the response.
         */
        public Builder masterNode() {
            return addCleanApiParameter("master_node");
        }

        /**
         * Shows the nodes part of the response
         */
        public Builder nodes() {
            return addCleanApiParameter("nodes");
        }

        /**
         * Shows the routing_table part of the response. 
         */
        public Builder routingTable() {
            return addCleanApiParameter("routing_table");
        }

        /**
         * Shows the metadata part of the response.
         */
        public Builder metadata() {
            return addCleanApiParameter("metadata");
        }

        /**
         * Shows the blocks part of the response
         */
        public Builder blocks() {
            return addCleanApiParameter("blocks");
        }

        /**
         * When not filtering metadata, a comma separated list of indices to include in the response.
         */
        public Builder indices(String value) {
            return setParameter("indices", value);
        }

        /**
         * For debugging purposes, you can retrieve the cluster state local to a particular node.
         */
        public Builder local() {
            return addCleanApiParameter("local");
        }

        @Override
        public State build() {
            return new State(this);
        }
    }
}