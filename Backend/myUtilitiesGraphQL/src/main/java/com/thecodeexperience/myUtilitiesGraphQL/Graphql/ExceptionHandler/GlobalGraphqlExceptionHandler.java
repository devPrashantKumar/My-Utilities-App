package com.thecodeexperience.myUtilitiesGraphQL.Graphql.ExceptionHandler;


import com.thecodeexperience.myUtilitiesGraphQL.Exception.GenericStatusException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GlobalGraphqlExceptionHandler extends DataFetcherExceptionResolverAdapter {

    public static final String GENERIC_EXCEPTION = "GENERIC_EXCEPTION";
    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    public static final String CODE = "code";

    @Override
    protected GraphQLError resolveToSingleError(
            Throwable ex,
            DataFetchingEnvironment env) {

        if (ex instanceof GenericStatusException) {
            return GraphqlErrorBuilder.newError(env)
                    .message(ex.getMessage())
                    .extensions(Map.of(CODE, GENERIC_EXCEPTION))
                    .build();
        }

        return GraphqlErrorBuilder.newError(env)
                .message(ex.getMessage())
                .extensions(Map.of(CODE, INTERNAL_SERVER_ERROR))
                .build();
    }
}