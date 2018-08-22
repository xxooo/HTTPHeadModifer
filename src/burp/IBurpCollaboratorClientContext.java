package burp;

/*
 * @(#)IBurpCollaboratorClientContext.java
 *
 * Copyright PortSwigger Ltd. All rights reserved.
 *
 * This code may be used to extend the functionality of Burp Suite Free Edition
 * and Burp Suite Professional, provided that this usage does not violate the
 * license terms for those products.
 */
import java.util.List;

/**
 * This interface represents an instance of a Burp Collaborator client context,
 * which can be used to generate Burp Collaborator payloads and poll the
 * Collaborator server for any network interactions that result from using those
 * payloads. Extensions can obtain new instances of this class by calling
 *  <code>IBurpExtenderCallbacks.createBurpCollaboratorClientContext()</code>.
 * Note that each Burp Collaborator client context is tied to the Collaborator
 * server configuration that was in place at the time the context was created.
 */
public interface IBurpCollaboratorClientContext
{

    /**
     * This method is used to generate new Burp Collaborator payloads.
     *
     * @param includeCollaboratorServerLocation Specifies whether to include the
     * Collaborator server location in the generated payload.
     * @return The payload that was generated.
     */
    String generatePayload(boolean includeCollaboratorServerLocation);

    /**
     * This method is used to retrieve all interactions received by the
     * Collaborator server resulting from payloads that were generated for this
     * context.
     *
     * @return The Collaborator interactions that have occurred resulting from
     * payloads that were generated for this context.
     */
    List<IBurpCollaboratorInteraction> fetchAllCollaboratorInteractions();

    /**
     * This method is used to retrieve interactions received by the Collaborator
     * server resulting from a single payload that was generated for this
     * context.
     *
     * @param payload The payload for which interactions will be retrieved.
     * @return The Collaborator interactions that have occurred resulting from
     * the given payload.
     */
    List<IBurpCollaboratorInteraction> fetchCollaboratorInteractionsFor(String payload);

    /**
     * This method is used to retrieve the network location of the Collaborator
     * server.
     *
     * @return The hostname or IP address of the Collaborator server.
     */
    String getCollaboratorServerLocation();
}